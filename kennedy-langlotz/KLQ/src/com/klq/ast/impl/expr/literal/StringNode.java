package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.value.StringValue;
import com.klq.ast.impl.value.Value;

import java.util.Map;

/**
 * Created by juriaan on 10-2-15.
 */
public class StringNode extends AExpression {
    private String string;

    public StringNode(String string, Location location) {
        super(location);
        this.string = string;
    }

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getString() {
        return string;
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        return new StringValue(string);
    }
}
