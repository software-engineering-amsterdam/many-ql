package com.klq.logic.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Timon on 17.02.2015.
 */
public class CalculationExpression extends AExpression {
    private final String NUMBER = "\\-?[0-9]*(\\.[0-9]*)?";
    private final String OPERATOR = "[\\+\\-\\*/]";

    public CalculationExpression(String content) {
        super(content);
    }

    @Override
    public String evaluate() {
        return evaluate(evalParentheses(content));
    }

    private String evalParentheses(String content){
        String result = content;
        while(true) {
            int parOpen = result.lastIndexOf("(");
            int parClose = result.indexOf(")", parOpen);
            if (parOpen == -1)
                break;
            String inner = result.substring(parOpen+1, parClose);
            result = result.replace("(" + inner + ")", evaluate(inner));
        }
        return result;
    }

    private String evaluate(String content) {
        List<String> values = new ArrayList(Arrays.asList(content.split(OPERATOR)));
        List<String> operators = new ArrayList(Arrays.asList(content.split(NUMBER)));
        operators = removeEmptyEntries(operators);
        while (true) {
            IndexOperationTuple tuple = findNextOperation(operators);
            if (tuple.getIndex() == -1)
                break;

            double left = Double.parseDouble(values.get(tuple.getIndex()));
            double right = Double.parseDouble(values.get(tuple.getIndex() + 1));
            values.remove(tuple.getIndex() + 1);
            operators.remove(tuple.getIndex());

            String product = "";

            switch (tuple.getOperation()) {
                case MUL:
                    product = Double.toString(left * right);
                    break;
                case DIV:
                    product = Double.toString(left / right);
                    break;
                case ADD:
                    product = Double.toString(left + right);
                    break;
                case SUB:
                    product = Double.toString(left - right);
                    break;
            }
            values.set(tuple.getIndex(), product);
        }
        return values.get(0);
    }

    private List<String> removeEmptyEntries(List<String> list){
        List<String> result = new ArrayList<String>();
        result.addAll(list);
        boolean cont = true;
        do {
            cont = result.remove("");
        } while (cont);
        return result;
    }

    private IndexOperationTuple findNextOperation(List<String> operators){
        int mulIndex = operators.indexOf("*");
        int divIndex = operators.indexOf("/");
        int addIndex = operators.indexOf("+");
        int subIndex = operators.indexOf("-");

        if (mulIndex != -1 || divIndex != -1){
            if (mulIndex == -1)
                return new IndexOperationTuple(divIndex, Operation.DIV);
            else if (divIndex == -1)
                return new IndexOperationTuple(mulIndex, Operation.MUL);
            else
                return new IndexOperationTuple(Math.min(mulIndex, divIndex),
                        (mulIndex < divIndex ? Operation.MUL : Operation.DIV));
        } else if (addIndex != -1 || subIndex != -1){
            if (addIndex == -1)
                return new IndexOperationTuple(subIndex, Operation.SUB);
            else if (subIndex == -1)
                return new IndexOperationTuple(addIndex, Operation.ADD);
            else
                return new IndexOperationTuple(Math.min(addIndex, subIndex),
                        (addIndex < subIndex ? Operation.ADD : Operation.SUB));
        }
        return new IndexOperationTuple();
    }

    enum Operation {
        MUL, DIV, ADD, SUB
    }

    class IndexOperationTuple {
        private final int index;
        private final Operation operation;

        public IndexOperationTuple(){
            this(-1, null);
        }

        public IndexOperationTuple(int index, Operation operation) {
            this.index = index;
            this.operation = operation;
        }

        public int getIndex() {
            return index;
        }

        public Operation getOperation() {
            return operation;
        }
    }
}
