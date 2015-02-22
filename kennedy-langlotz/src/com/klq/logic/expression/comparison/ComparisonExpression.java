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

        int result = parse(left).compareTo(parse(right));


        return null;
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
