package com.klq.logic.expression;

import com.klq.logic.expression.token.*;
import com.klq.logic.expression.token.Number;

import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Timon on 17.02.2015.
 */
public class CalculationExpression extends AExpression {

    public CalculationExpression(String content) {
        super(content);
    }

    @Override
    public String evaluate() throws IllegalArgumentException{
        Tokenizer tokenizer = new Tokenizer(this);
        Queue<AToken> outputQueue = new LinkedBlockingDeque<AToken>();
        Stack<AToken> stack = new Stack<AToken>();
        while (tokenizer.hasNext()){
            AToken token = tokenizer.nextToken();
            switch (token.getType()) {
                case AToken.NUMBER:
                    outputQueue.add(token);
                    break;
                case AToken.OPERATOR:
                    Operator o1 = (Operator) token;
                    try {
                        AToken o2 = stack.peek();
                        while (o2.getType() == AToken.OPERATOR && (o1.getPrecedence() <= ((Operator)o2).getPrecedence()))
                            outputQueue.add(stack.pop());
                    } catch (EmptyStackException e) {}
                    stack.push(o1);
                    break;
                case AToken.PARENTHESES_OPEN:
                    stack.push(token);
                    break;
                case AToken.PARENTHESES_CLOSE:
                    try {
                        while (stack.peek().getType() != AToken.PARENTHESES_OPEN) {
                            AToken t = stack.pop();
                            if (t == null) {
                                throw new IllegalArgumentException("Mismatched parentheses!");
                            }
                            outputQueue.add(t);
                        }
                    } catch (EmptyStackException e) {}
                    stack.pop();
                    break;
            }
        }
        try {
            while (stack.peek() != null) {
                AToken t = stack.pop();
                if (t.getType() == AToken.PARENTHESES_OPEN || t.getType() == AToken.PARENTHESES_CLOSE)
                    throw new IllegalArgumentException("Mismatched parentheses!");
                outputQueue.add(t);
            }
        } catch (EmptyStackException e) {}

        return evaluateRpn(outputQueue);
    }

    private String evaluateRpn(Queue<AToken> queue) throws IllegalArgumentException{
        Stack<AToken> stack = new Stack<AToken>();
        while(!queue.isEmpty()){
            AToken top = queue.poll();
            if (top.getType() == AToken.NUMBER) {
                stack.push(top);
            } else if (top.getType() == AToken.OPERATOR) {
                double right = Double.valueOf(((Number) stack.pop()).getValue());
                double left = Double.valueOf(((Number) stack.pop()).getValue());
                stack.push(calculate(left, right, ((Operator)top).getOperatorType()));
            } else
                throw new IllegalArgumentException("Queue not well formed!");
        }
        return ((Number)stack.pop()).getValue();
    }

    private Number calculate(double left, double right, Operator.OperatorType operator)
            throws IllegalArgumentException{
        switch (operator){
            case MUL: return new Number(left * right);
            case DIV: return new Number(left / right);
            case ADD: return new Number(left + right);
            case SUB: return new Number(left - right);
        }
        throw new IllegalArgumentException("Unknown operation: " + operator);
    }

    private String toRPN(PriorityQueue<AToken> queue){
        String result = "";
        for (AToken token : queue){
            switch (token.getType()){
                case AToken.NUMBER:
                    result += ((Number) token).getValue();
                    break;
                case AToken.OPERATOR:
                    result += ((Operator) token).getOperatorType();
                    break;
                default: result += "ERR";
            }
            result += " ";
        }
        return result.trim();
    }
}
