package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class NumberNode extends AValueNode<BigDecimal> {
    public NumberNode(BigDecimal number, String location) {
        super(number, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        return this;
    }
}
