package com.klq.ast.impl.expr.bool;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.value.BooleanValue;
import com.klq.ast.impl.value.ComparableValue;
import com.klq.ast.impl.value.UndefinedValue;
import com.klq.ast.impl.value.Value;
import com.klq.controller.VariableTable;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class GreaterThanNode extends ABooleanNode {

    public GreaterThanNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public GreaterThanNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(VariableTable variableTable) {
        ComparableValue left = (ComparableValue)(getLeftChild().evaluate(variableTable));
        ComparableValue right = (ComparableValue)(getRightChild().evaluate(variableTable));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else {
            return new BooleanValue(left.compareTo(right) > 0);
        }
    }
}
