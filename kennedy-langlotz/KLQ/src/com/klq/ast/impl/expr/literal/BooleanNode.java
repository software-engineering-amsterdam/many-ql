package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.value.BooleanValue;
import com.klq.ast.impl.value.Value;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public class BooleanNode extends AExpression{
    private final boolean value;

    public BooleanNode(boolean value, Location location) {
        super(location);
        this.value = value;
    }

    public BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        return new BooleanValue(value);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean getValue(){
        return value;
    }
}
