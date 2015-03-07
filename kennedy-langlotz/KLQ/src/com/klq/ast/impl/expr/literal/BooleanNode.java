package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.logic.value.BooleanValue;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.Value;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public class BooleanNode extends AExpression{
    private final boolean value;

    public BooleanNode(boolean value, String location) {
        super(null, null, location);
        this.value = value;
    }

    @Override
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        return new BooleanValue(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BooleanNode){
            return ((BooleanNode)obj).value == this.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean getValue(){
        return value;
    }
}
