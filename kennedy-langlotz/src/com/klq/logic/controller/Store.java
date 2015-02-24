package com.klq.logic.controller;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Date;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem{
    private List<Id> order;
    private Map<Id, Question> store;

    public Store() {
        order = new ArrayList<Id>();
        store = new HashMap<Id, Question>();
    }

    public Question add(Question question){
        order.add(question.getId());
        try {
            question.setStore(this);
        } catch (Exception e){
            System.err.println("Store has already been set!");
        }
        return store.put(question.getId(), question);
    }

    public Question get(Id questionId){
        return store.get(questionId);
    }

    public List<Question> getOrderedQuestions(){
        List<Question> result = new ArrayList<Question>();
        for (Id id : order) {
            result.add(store.get(id));
        }
        return result;
    }

    public void update(Id updated){
        Question answered = store.get(updated);
        String answerString = answered.getResult().toString();
        AExpression newExpr;
        switch (answered.getType()){
            case BOOLEAN:
                if ("True".equals(answered.getResult()))
                    newExpr = Boolean.getTrue();
                else
                    newExpr = Boolean.getFalse();
                break;
            case DATE:
                newExpr = new Date(answerString);
                break;
            case NUMERAL:
                newExpr = new Number(answerString);
                break;
            default:
                newExpr = new com.klq.logic.expression.terminal.String(answerString);
                break;
        }
        for (Question q : store.values()) {
            List<AExpression> dList = q.getDependencies();
            if (dList != null) {
                for (AExpression expr : dList) {
                    AExpression eval = expr.evaluate();
                    System.out.println(eval);
                    if (expr.getType() == AExpression.IDENTIFIER
                            && updated.equals(expr.getContent())) {
                        q.updateDependency(expr, newExpr);
                        update(q.getId());
                    }
                }
            }
        }
    }
}
