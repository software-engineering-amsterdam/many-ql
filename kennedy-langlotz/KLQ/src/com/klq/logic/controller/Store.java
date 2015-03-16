package com.klq.logic.controller;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.IdentifierValue;
import com.klq.ast.impl.expr.value.UndefinedValue;
import com.klq.ast.impl.expr.value.Value;
import com.klq.logic.IKLQItem;
import com.klq.logic.question.Question;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem {
    private final List<IdentifierValue> order;
    private final Map<IdentifierValue, Question> store;
    private final Map<String, Value> variables;

    private final DoubleProperty progressProperty;

    public Store() {
        order = new ArrayList<>();
        store = new HashMap<>();
        variables = new HashMap<>();
        progressProperty = new SimpleDoubleProperty(0);
    }

    public void add(Question question) {
        order.add(question.getID());
        store.put(question.getID(), question);

        IdentifierValue id = question.getID();

        if (!question.isComputedQuestion()) {
            variables.put(id.getValue(), new UndefinedValue());
        } else {
            variables.put(id.getValue(), question.getComputedExpression().evaluate(variables));
        }
    }

    public List<Question> getOrderedQuestions() {
        List<Question> result = new ArrayList<>();
        for (IdentifierValue id : order) {
            result.add(store.get(id));
        }
        return result;
    }

    public Map<String, Value> getVariables() {
        return variables;
    }

    public boolean dependenciesResolved(IdentifierValue questionId) {
        Question question = store.get(questionId);
        if (question == null) {
            assert false;
        }
        return question.dependenciesResolved(variables);
    }

    public void updateAnswer(IdentifierValue questionId, Value answer) {
        assert(variables.containsKey(questionId));
        if (answer == null){
            variables.put(questionId.getValue(), new UndefinedValue());
        } else {
            variables.put(questionId.getValue(), answer);
        }

        updateQuestionVisibilities();
        updateComputedQuestions();
        updateQuestionnaireProgress();
    }

    public void updateQuestionVisibilities(){
        for (IdentifierValue id : store.keySet()){
            boolean visible = dependenciesResolved(id);
            Question q = store.get(id);
            if (q.isVisible() != visible) {
                q.setVisible(visible);
            }
        }
    }

    private void updateComputedQuestions(){
        Collection<Question> questions = store.values();
        questions.forEach(question -> {
            if (question.isComputedQuestion()) {
                AExpression computedExpression = question.getComputedExpression();
                Value result = computedExpression.evaluate(variables);
                question.setComputedValue(result.toString());
            }
        });
    }

    private void updateQuestionnaireProgress(){
        double answered = 0;
        double total = 0;
        for (Question q : store.values()){
            if (!q.isComputedQuestion()){
                total++;
                Value v = variables.get(q.getID().getValue());
                if (!v.equals(new UndefinedValue())){
                    answered++;
                }
            }
        }
        progressProperty.setValue(answered/total);
    }

    public DoubleProperty progressProperty(){
        return progressProperty;
    }

    public boolean exportResults(String path){
        DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
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
