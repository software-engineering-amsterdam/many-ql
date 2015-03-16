package com.klq.ast.impl.expr.literal;

import com.klq.ast.Location;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.NumberValue;
import com.klq.ast.impl.expr.value.Value;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class NumberNode extends AExpression {
    private BigDecimal number;

    public NumberNode(BigDecimal number, Location location) {
        super(location);
        this.number = number;
    }

    public NumberNode(BigDecimal number) {
        this.number = number;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        return new NumberValue(number);
    }

    public BigDecimal getNumber() {
        return number;
    }
}
