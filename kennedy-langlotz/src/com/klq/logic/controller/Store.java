package com.klq.logic.controller;

import com.klq.gui.IStoreListener;
import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Identifier;
import com.klq.logic.expression.util.Pair;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem {
    private List<Id> order;
    private Map<Id, Question> store;
    private List<IStoreListener> listeners;

    public Store() {
        order = new ArrayList<Id>();
        store = new HashMap<Id, Question>();
        listeners = new ArrayList<IStoreListener>();
    }

    public void addStoreListener(IStoreListener listener) {
        this.listeners.add(listener);
    }

    public Question add(Question question) {
        order.add(question.getId());
        try {
            question.setStore(this);
        } catch (Exception e) {
            System.err.println("Store has already been set!");
        }
        return store.put(question.getId(), question);
    }

    public List<Question> getOrderedQuestions() {
        List<Question> result = new ArrayList<Question>();
        for (Id id : order) {
            result.add(store.get(id));
        }
        return result;
    }

    public void update() {
        List<Id> needUpdate = new ArrayList<Id>();
        for (Question question : store.values()) {
            List<AExpression> dependencies = question.getDependencies();
            List<Pair<AExpression>> replacements = findReplacements(dependencies);
            updateDependencies(question, replacements);

            if (!replacements.isEmpty())
                needUpdate.add(question.getId());
        }
        updateListeners(needUpdate);
    }

    private List<Pair<AExpression>> findReplacements(List<AExpression> dependencies) {
        List<Pair<AExpression>> result = new ArrayList<Pair<AExpression>>();
        if (dependencies == null && dependencies.isEmpty())
            return result;
        for (AExpression expr : dependencies) {
            if (expr.isTerminal(false))
                continue;
            AExpression iterated = iterate(expr);
            if (iterated == null)
                System.err.println("Expression is null!");
            result.add(new Pair(expr, iterated.evaluate()));
        }
        return result;
    }

    private AExpression iterate(AExpression expr){
        if (expr != null) {
            switch (expr.getType()) {
                case AExpression.IDENTIFIER:
                    return resolveIdentifier(expr);
                case AExpression.DATE:
                case AExpression.NUMBER:
                case AExpression.STRING:
                case AExpression.BOOLEAN:
                    return expr;
            }
        }
        if (expr.getLeft() != null && expr.getRight() != null)
            return AExpression.copyExpressionFrom(expr, iterate(expr.getLeft()), iterate(expr.getRight()));
        else if (expr.getLeft() == null && expr.getRight() != null)
            return AExpression.copyExpressionFrom(expr, expr.getLeft(), iterate(expr.getRight()));
        else if (expr.getLeft() != null && expr.getRight() == null)
            return AExpression.copyExpressionFrom(expr, iterate(expr.getLeft()), expr.getRight());
        return null; //We should not get to this point
    }

    private AExpression resolveIdentifier(AExpression id){
        if (id == null || id.getType() != AExpression.IDENTIFIER)
            return null;

        Identifier identifier = (Identifier) id;
        Question question = store.get(getOrignialIdentifier(identifier.getContent()));
        return question.getResult();
    }

    //IDs differ, because different IDs are created for questions and dependencies.
    //Method serves as a workaround.
    private Id getOrignialIdentifier(String value){
        for (Id id : order) {
            if (id.equals(value))
                return id;
        }
        return null;
    }

    private void updateDependencies(Question question, List<Pair<AExpression>> replacements) {
        for(Pair<AExpression> replacement : replacements){
            question.updateDependency(replacement.getLeft(), replacement.getRight());
        }
    }

    private void updateListeners(List<Id> changed){
        for (IStoreListener listener : listeners) {
            listener.storeUpdated(changed);
        }
    }
}
