package com.klq.logic.expression.comparison;

import com.klq.logic.expression.AExpression;

/**
 * Created by Timon on 22.02.2015.
 */
public class ComparisonExpression extends AExpression {

    public ComparisonExpression(String content) {
        super(content);
    }

    @Override
    public String evaluate() throws IllegalArgumentException {
        String[] comparators = content.split(ComparatorOperation.regex());
        String left = comparators[0];
        String right = comparators[1];

        ComparatorOperation co = null;
        if (content.contains(ComparatorOperation.GREATER_THAN.getOperator()))
            co = ComparatorOperation.GREATER_THAN;
        else if (content.contains(ComparatorOperation.GREATER_EQUAL.getOperator()))
            co = ComparatorOperation.GREATER_EQUAL;
        else if (content.contains(ComparatorOperation.LESS_EQUAL.getOperator()))
            co = ComparatorOperation.LESS_EQUAL;
        else if (content.contains(ComparatorOperation.LESS_THAN.getOperator()))
            co = ComparatorOperation.LESS_THAN;
        else if (content.contains(ComparatorOperation.EQUAL.getOperator()))
            co = ComparatorOperation.EQUAL;
        else if (content.contains(ComparatorOperation.NOT_EQUAL.getOperator()))
            co = ComparatorOperation.NOT_EQUAL;


        int result = parse(left).compareTo(parse(right));
        if (result == AComparator.UNCOMPARABLE)
            throw new IllegalArgumentException("The two expressions are not comparable!");

        switch (co){
            case LESS_EQUAL:
                return (new Boolean(result == -1)).toString();
            case LESS_THAN:
                return (new Boolean(result == -1 || result == 0)).toString();
            case EQUAL:
                return (new Boolean(result == 0)).toString();
            case GREATER_EQUAL:
                return (new Boolean(result == 0 || result == 1)).toString();
            case GREATER_THAN:
                return (new Boolean(result == 1)).toString();
            case NOT_EQUAL:
                return (new Boolean(result == 1 || result == -1)).toString();
            default:
                throw new IllegalArgumentException("Could not evaluate!");
        }
    }

    private AComparator parse(String comparator){
        if (comparator.matches("([0-9]*" + KLQDate.SEPARATORS + "){3}"))
            return new KLQDate(comparator);
        else if (comparator.matches("[0-9]*(\\.[0-9]*)?"))
            return new KLQNumber(comparator);
        else
            return new KLQString(comparator);
    }
}
