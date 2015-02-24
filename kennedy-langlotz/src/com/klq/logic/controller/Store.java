package com.klq.logic.controller;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.operator.bool.*;
import com.klq.logic.expression.operator.math.Addition;
import com.klq.logic.expression.operator.math.Division;
import com.klq.logic.expression.operator.math.Multiplication;
import com.klq.logic.expression.operator.math.Subtraction;
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

    private Id getIdFor(String identifier){
        for (Id id : order) {
            if (id.equals(identifier))
                return id;
        }
        return null;
    }

    public void update(Id updated){
        for (Question q : store.values()) {
            List<ReplacementTuple> replacements = new ArrayList<ReplacementTuple>();
            List<AExpression> dList = q.getDependencies();
            if (dList != null) {
                for (AExpression expr : dList) {
                    AExpression eval = expr.evaluate();
                    Id toCheck;
                    AExpression left = null, right = null;
                    if (eval.getLeft() != null && eval.getLeft().getType() == AExpression.IDENTIFIER){
                        toCheck = getIdFor(eval.getLeft().getContent());
                        if (updated.equals(toCheck)) {
                            left = createExpressionFromAnswer(toCheck);
                        }
                    }
                    if (eval.getRight() != null && eval.getRight().getType() == AExpression.IDENTIFIER){
                        toCheck = getIdFor(eval.getRight().getContent());
                        if (updated.equals(toCheck)) {
                            right = createExpressionFromAnswer(toCheck);
                        }
                    }
                    if (left != null || right != null) {
                        AExpression replacement = copyExpressionFrom(expr, left, right).evaluate();
                        replacements.add(new ReplacementTuple(expr, replacement));
                    }
                }
            }
            for (ReplacementTuple rt : replacements){
                q.updateDependency(rt.getExpression(), rt.getReplacement());
            }
        }
    }

    private AExpression copyExpressionFrom(AExpression current, AExpression newLeft, AExpression newRight){
        AExpression left = (newLeft != null ? newLeft : current.getLeft());
        AExpression right = (newRight != null ? newRight : current.getRight());
        switch (current.getType()){
            case AExpression.ADD: return new Addition(left, right);
            case AExpression.AND: return new And(left, right);
            case AExpression.DIV: return new Division(left, right);
            case AExpression.EQUALS: return new Equals(left, right);
            case AExpression.GREATER_EQUALS: return new GreaterEquals(left, right);
            case AExpression.GREATER_THAN: return new GreaterThan(left, right);
            case AExpression.LESS_EQUALS: return new LessEquals(left, right);
            case AExpression.LESS_THAN: return new LessThan(left, right);
            case AExpression.MUL: return new Multiplication(left, right);
            case AExpression.NOT_EQUALS: return new NotEquals(left, right);
            case AExpression.OR: return new Or(left, right);
            case AExpression.SUB: return new Subtraction(left, right);
            default: return null;
        }
    }

    private AExpression createExpressionFromAnswer(Id source){
        Question answered = store.get(source);
        String answerString = answered.getResult().getContent();
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
        return newExpr;
    }

    private AExpression resolve(AExpression expr){
        if (expr.getType() == AExpression.IDENTIFIER) {
            Id id = new Id(expr.getContent());
            Question question = store.get(id);

        }
        return null;
    }

    class ReplacementTuple {
        private AExpression expression;
        private AExpression replacement;

        public ReplacementTuple(AExpression expression, AExpression replacement) {
            this.expression = expression;
            this.replacement = replacement;
        }

        public AExpression getExpression() {
            return expression;
        }

        public AExpression getReplacement() {
            return replacement;
        }
    }
}
