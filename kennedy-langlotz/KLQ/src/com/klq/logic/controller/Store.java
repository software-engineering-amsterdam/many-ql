package com.klq.logic.controller;

import com.klq.ast.impl.expr.AExpression;
import com.klq.logic.IKLQItem;
import com.klq.logic.question.Question;
import com.klq.ast.impl.expr.value.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem {
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private final List<IdentifierValue> order;
    private final Map<IdentifierValue, Question> store;
    private final Map<String, Value> variables;

    private final String NO_SUCH_QUESTION = "Question with ID \"%s\" does not exist!";

    private int computedCount = 0;
    private int invisibleCount = 0;

    private final DoubleProperty progressProperty;

    public Store() {
        order = new ArrayList<>();
        store = new HashMap<>();
        variables = new HashMap<>();
        progressProperty = new SimpleDoubleProperty(0);
    }

    public void add(Question question) {
        order.add(question.getId());
        store.put(question.getId(), question);

        IdentifierValue id = question.getId();

        if (!question.isComputedQuestion()) {
            UndefinedValue undefined = new UndefinedValue();
            variables.put(id.getValue(), undefined);
        } else {
            variables.put(id.getValue(), question.getComputedExpression().evaluate(variables));
            computedCount++;
        }
    }

    public List<Question> getOrderedQuestions() {
        List<Question> result = new ArrayList<Question>();
        for (IdentifierValue id : order) {
            result.add(store.get(id));
        }
        return result;
    }

    public Map<String, Value> getVariables() {
        return variables;
    }

    public boolean dependenciesResolved(IdentifierValue questionId){
        Question question = store.get(questionId);
        if (question == null)
            assert false;

        List<AExpression> dependencies = question.getDependencies();
        for (AExpression d : dependencies) {
            if (!isSatisfied(d))
                return false;
        }
        return true;
    }

    private boolean isSatisfied(AExpression expression){
        Value result = expression.evaluate(variables);

        if (result.isUndefined()) {
            return false;
        } else {
            return (boolean) result.getValue();
        }

    }

    public void updateAnswer(IdentifierValue questionId, Value answer) {
        assert(variables.containsKey(questionId));
        variables.put(questionId.getValue(), answer);

        updateVisibilities();
        updateComputed();
        updateProgress();
    }

    public void updateVisibilities(){
        invisibleCount = 0;
        for (IdentifierValue id : store.keySet()){
            boolean visible = dependenciesResolved(id);
            if (!visible) {
                invisibleCount++;
            }
            BooleanProperty property = store.get(id).visibleProperty();
            if (property.get() != visible) {
                property.setValue(visible);
            }
        }
    }

    private void updateComputed(){
        for (Question q : store.values()){
            if (q.isComputedQuestion()){
                AExpression computedExpression = q.getComputedExpression();
                Value result = computedExpression.evaluate(variables);
                q.computedProperty().setValue(result.toString());
            }
        }
    }

    private void updateProgress(){
        double count = variables.size() - computedCount - invisibleCount;
        double answered = 0;
        for (String expr : variables.keySet()) {
            Value assignedValue = variables.get(expr);
            System.out.println(assignedValue.toString());
            if (!(assignedValue.isUndefined()))
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
            for (IdentifierValue id : order) {
                Value assignedValue = variables.get(id);
                String varString = assignedValue.toString();
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
