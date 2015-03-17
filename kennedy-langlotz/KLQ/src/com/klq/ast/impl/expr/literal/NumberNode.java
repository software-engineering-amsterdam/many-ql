package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.value.NumberValue;
import com.klq.ast.impl.value.Value;

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
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        return new NumberValue(number);
    }

    public BigDecimal getNumber() {
        return number;
    }
}
