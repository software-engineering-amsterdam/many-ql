package com.klq.ast.impl.expr.bool;

import com.klq.ast.Location;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.BooleanValue;
import com.klq.ast.impl.expr.value.UndefinedValue;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class EqualsNode extends ABooleanNode {

    public EqualsNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public EqualsNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        Value left = (getLeftChild().evaluate(variables));
        Value right =(getRightChild().evaluate(variables));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else{
            return new BooleanValue(left.equals(right));
        }
    }
}
