package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.StringValue;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by juriaan on 10-2-15.
 */
public class StringNode extends AExpression {
    private String string;

    public StringNode(String string, String location) {
        super(null, null, location);
        this.string = string;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getString() {
        return string;
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        return new StringValue(string);
    }
}
