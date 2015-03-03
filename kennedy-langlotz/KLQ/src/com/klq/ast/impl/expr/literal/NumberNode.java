package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.NumberValue;
import com.klq.logic.value.Value;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class NumberNode extends AExpression {
    private BigDecimal number;

    public NumberNode(BigDecimal number, String location) {
        super(null, null, location);
        this.number = number;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        return new NumberValue(number);
    }

    public BigDecimal getNumber() {
        return number;
    }
}
