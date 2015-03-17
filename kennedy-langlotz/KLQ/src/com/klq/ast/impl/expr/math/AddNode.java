package com.klq.ast.impl.expr.math;

import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.Location;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.value.NumberValue;
import com.klq.ast.impl.value.UndefinedValue;
import com.klq.ast.impl.value.Value;
import com.klq.controller.VariableTable;

import java.math.BigDecimal;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class AddNode extends AMathNode {

    public AddNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public AddNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(VariableTable variableTable) {
        Value left = (getLeftChild().evaluate(variableTable));
        Value right = (getRightChild().evaluate(variableTable));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else {
            BigDecimal leftValue = (BigDecimal) left.getValue();
            BigDecimal rightValue = (BigDecimal) right.getValue();
            return new NumberValue(leftValue.add(rightValue));
        }
    }
}
