package com.klq.controller;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.value.UndefinedValue;
import com.klq.ast.impl.value.Value;
import com.klq.gui.IKLQItem;
import com.klq.gui.control.ARenderedQuestion;
import com.klq.gui.control.ComputedRenderedQuestion;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.antlr.v4.runtime.misc.NotNull;

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
public class Controller implements IKLQItem {
    private final List<IdentifierNode> order;
    private final Map<IdentifierNode, ARenderedQuestion> questionStore;
    private final Map<IdentifierNode, Value> variables;

    private final DoubleProperty progressProperty;

    public Controller() {
        order = new ArrayList<>();
        questionStore = new HashMap<>();
        variables = new HashMap<>();
        progressProperty = new SimpleDoubleProperty(0);
    }

    public void add(ARenderedQuestion question) {
        order.add(question.getID());
        questionStore.put(question.getID(), question);
        variables.put(question.getID(), new UndefinedValue());
    }

    public List<ARenderedQuestion> getOrderedQuestions() {
        List<ARenderedQuestion> result = new ArrayList<>();
        for (IdentifierNode id : order) {
            result.add(questionStore.get(id));
        }
        return result;
    }

    public Map<IdentifierNode, Value> getVariables() {
        return variables;
    }


    public boolean dependenciesResolved(IdentifierNode questionId) {
        assert questionStore.containsKey(questionId): "All questions should be in the question store.";
        ARenderedQuestion question = questionStore.get(questionId);

        return question.dependenciesResolved(variables);
    }

    public void updateAnswer(IdentifierNode questionId, @NotNull Value answer) {
        assert(variables.containsKey(questionId));
        variables.put(questionId, answer);

        updateQuestionVisibilities();
        updateComputedQuestions();
        updateQuestionnaireProgress();
    }

    public void updateQuestionVisibilities(){
        for (IdentifierNode id : questionStore.keySet()){
            boolean visible = dependenciesResolved(id);
            ARenderedQuestion q = questionStore.get(id);
            if (q.isVisible() != visible) {
                q.setVisible(visible);
            }
        }
    }

    private void updateComputedQuestions(){
        Collection<ARenderedQuestion> questions = questionStore.values();
        questions.forEach(question -> {
            if (question.isComputed()) {
                ComputedRenderedQuestion crq = (ComputedRenderedQuestion) question;
                AExpression computedExpression = crq.getComputedExpression();
                Value result = computedExpression.evaluate(variables);
                crq.updateComputedValue(result.toString());
            }
        });
    }

    private void updateQuestionnaireProgress(){
        double answered = 0;
        double total = 0;
        for (ARenderedQuestion q : questionStore.values()){
            if (!q.isComputed()){
                total++;
                Value v = variables.get(q.getID());
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
            for (IdentifierNode id : order) {
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
