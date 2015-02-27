package com.klq.logic.controller;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.util.ExpressionUtil;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store implements IKLQItem {
    private final List<Id> order;
    private final Map<Id, Question> store;
    private final Map<AExpression, AExpression> variables;

    private final String NO_SUCH_QUESTION = "Question with ID \"%s\" does not exist!";

    public Store() {
        order = new ArrayList<Id>();
        store = new HashMap<Id, Question>();
        variables = new HashMap<AExpression, AExpression>();
    }

    public void add(Question question) {
        order.add(question.getId());
        store.put(question.getId(), question);

        //TODO replace question.Id with AExpression?
        String id = question.getId().toString();
        AExpression exprId = new Identifier(id);
        variables.put(exprId, exprId);
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
            variables.put(id, answer);
        else
            throw new NoSuchQuestionException("Error while updating variable table!\n"
                    + String.format(NO_SUCH_QUESTION, questionId));
        updateVisibilities();
    }

    public void updateVisibilities(){
        for (Id id : store.keySet()){
            try {
                boolean visibility = dependenciesResolved(id);
                store.get(id).visibleProperty().setValue(visibility);
            } catch (NoSuchQuestionException nsq){
                System.err.println("Error while updating visibilities!"
                        + String.format(NO_SUCH_QUESTION, id));
            }
        }
    }

    public String getComputedValue(Id questionId){
        return "---";
    }
}
