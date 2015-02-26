package com.klq.logic.controller;

import com.klq.gui.IStoreListener;
import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Identifier;
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

    public void update(Question updatedComputedQuestion){
        for (Question question : store.values()) {
            List<AExpression> dependencies = question.getDependencyList();
            for (AExpression dependency : dependencies) {
                iterate(dependency);
            }
            //if computed question, evaluate
            if (question.isComputedQuestion()) {
                AExpression questionResult = iterate(question.getResult());
                if (questionResult != null){
                    if (question != updatedComputedQuestion)
                        question.setResult(questionResult, true);
                    else
                       question.setResult(questionResult, false);
                }
            }
        }
        updateListeners();
    }

    private AExpression iterate(AExpression expr){
        if (expr != null) {
            switch (expr.getType()) {
                case AExpression.IDENTIFIER:
                    AExpression variable = resolveIdentifier(expr);
                    ((Identifier)expr).assignVariable(variable);
                    return expr;
                case AExpression.DATE:
                case AExpression.NUMBER:
                case AExpression.STRING:
                case AExpression.BOOLEAN:
                    return expr;
            }
        }
        if (expr.getLeft() != null)
            iterate(expr.getLeft());
        if (expr.getRight() != null)
            iterate(expr.getRight());
         return expr;
    }

    private AExpression resolveIdentifier(AExpression id){
        if (id == null || id.getType() != AExpression.IDENTIFIER)
            return id;

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

    private void updateListeners(){
        for (IStoreListener listener : listeners) {
            listener.storeUpdated();
        }
    }
}
