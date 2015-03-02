package com.klq.logic.controller;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.util.ExpressionUtil;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.*;
import java.lang.String;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem {
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private final List<Id> order;
    private final Map<Id, Question> store;
    private final Map<AExpression, AExpression> variables;

    private final String NO_SUCH_QUESTION = "Question with ID \"%s\" does not exist!";

    private int computedCount = 0;
    private int invisibleCount = 0;

    private final DoubleProperty progressProperty;

    public Store() {
        order = new ArrayList<Id>();
        store = new HashMap<Id, Question>();
        variables = new HashMap<AExpression, AExpression>();
        progressProperty = new SimpleDoubleProperty(0);
    }

    public void add(Question question) {
        order.add(question.getId());
        store.put(question.getId(), question);

        //TODO replace question.Id with AExpression?
        String id = question.getId().toString();
        AExpression exprId = new Identifier(id);
        if (!question.isComputedQuestion())
            variables.put(exprId, exprId);
        else {
            variables.put(exprId, question.getComputedValue());
            computedCount++;
        }
    }

    public List<Question> getOrderedQuestions() {
        List<Question> result = new ArrayList<Question>();
        for (Id id : order) {
            result.add(store.get(id));
        }
        return result;
    }

    public boolean dependenciesResolved(Id questionId) throws NoSuchQuestionException{
        Question question = store.get(questionId);
        if (question == null)
            throw new NoSuchQuestionException(String.format(NO_SUCH_QUESTION, questionId));

        List<AExpression> dependencies = question.getDependencies();
        for (AExpression d : dependencies) {
            if (!isSatisfied(d))
                return false;
        }
        return true;
    }

    private boolean isSatisfied(AExpression expression){
        AExpression result = iterate(expression).evaluate();
        if (result == Boolean.getTrue())
            return true;
        return false;

    }

    private AExpression iterate(AExpression expr){
        if (expr == null) 
            return null;
        
        switch (expr.getType()) {
            case AExpression.IDENTIFIER:
                return variables.get(expr);
            case AExpression.DATE:
            case AExpression.NUMBER:
            case AExpression.STRING:
            case AExpression.BOOLEAN:
                return expr;
            default:
                return ExpressionUtil.copyExpressionFrom(expr.evaluate(),
                        iterate(expr.getLeft()).evaluate(),
                        iterate(expr.getRight()).evaluate()
                );
        }
    }

    public void updateAnswer(Id questionId, AExpression answer) throws NoSuchQuestionException{
        AExpression id = new Identifier(questionId.toString());
        if (variables.containsKey(id))
            variables.put(id, answer != null ? answer : id);
        else
            throw new NoSuchQuestionException("Error while updating variable table!\n"
                    + String.format(NO_SUCH_QUESTION, questionId));
        updateVisibilities();
        updateComputed();
        updateProgress();
    }

    public void updateVisibilities(){
        invisibleCount = 0;
        for (Id id : store.keySet()){
            try {
                boolean visible = dependenciesResolved(id);
                if (!visible) {
                    invisibleCount++;
                }
                BooleanProperty property = store.get(id).visibleProperty();
                if (property.get() != visible) {
                    property.setValue(visible);
                }
            } catch (NoSuchQuestionException nsq){
                System.err.println("Error while updating visibilities!"
                        + String.format(NO_SUCH_QUESTION, id));
            }
        }
    }

    private void updateComputed(){
        for (Question q : store.values()){
            if (q.isComputedQuestion()){
                AExpression var = new Identifier(q.getId().toString());
                AExpression computed = iterate(variables.get(var)).evaluate();
                q.computedProperty().setValue(computed.getContent());
            }
        }
    }

    private void updateProgress(){
        double count = variables.size() - computedCount - invisibleCount;
        double answered = 0;
        for (AExpression expr : variables.keySet()) {
            AExpression assignedValue = variables.get(expr).evaluate();
            if (ExpressionUtil.isTerminal(assignedValue, false))
                answered++;
        }
        progressProperty.set((answered)/count);
    }

    public DoubleProperty progressProperty(){
        return progressProperty;
    }

    public boolean exportResults(String path){
        Date timestamp = new Date();
        File file = new File(path + File.separator + DATE_FORMAT.format(timestamp) + ".xml");
        try {
            file.createNewFile();
            String encoding = "UTF-8";
            PrintWriter writer = new PrintWriter(file, encoding);
            writer.write(String.format("<?xml version=\"1.0\" encoding=\"" + encoding + "\"?>%n"));
            writer.write(String.format("<questionnaire>%n"));
            for (Id id : order) {
                AExpression var = new Identifier(id.toString());
                AExpression assignedValue = iterate(variables.get(var)).evaluate();
                String varString = assignedValue.getContent();
                String xmlTag = String.format("\t<%s>%n" + "\t\t%s%n" + "\t</%s>%n",
                                                id.toString(), varString, id.toString());
                writer.write(xmlTag);
            }
            writer.write("</questionnaire>");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException fnf){
            System.err.println(String.format("Could not write to file: %s", file));
            return false;
        } catch (IOException io){
            System.err.println(String.format("Could not create file: %s", file));
            return false;
        }
        return true;
    }
}
