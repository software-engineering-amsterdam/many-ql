package com.klq.logic.controller;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.ExpressionUtil;
import com.klq.ast.impl.expr.literal.BooleanNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.logic.IKLQItem;
import com.klq.logic.question.Question;
import com.klq.logic.value.BooleanValue;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.UndefinedValue;
import com.klq.logic.value.Value;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    private final Map<IdentifierValue, Value> variables;

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
            variables.put(id, undefined);
        } else {

            variables.put(id, question.getComputedValue());
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
        BooleanValue result = (BooleanValue)(expression.evaluate(variables));
        if (result.getValue())
            return true;
        return false;

    }

    public void updateAnswer(IdentifierValue questionId, Value answer) {
        if (variables.containsKey(questionId))
            variables.put(questionId, answer);
        else
            assert false;
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
                //Value computed = variables.get(q.getId()).evaluate(variables);
                //q.computedProperty().setValue(computed.toString());
            }
        }
    }

    private void updateProgress(){
        double count = variables.size() - computedCount - invisibleCount;
        double answered = 0;
        for (IdentifierValue expr : variables.keySet()) {
            Value assignedValue = variables.get(expr);
            if (!(assignedValue.equals(new UndefinedValue())))
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
