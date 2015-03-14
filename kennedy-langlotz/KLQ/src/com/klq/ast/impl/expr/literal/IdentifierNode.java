package com.klq.ast.impl.expr.literal;

import com.common.ast.Location;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by juriaan on 23-2-15.
 */
public class IdentifierNode extends AExpression {
    private String identifier;

    public IdentifierNode(String identifier, Location location) {
        super(location);
        this.identifier = identifier;
    }

    public IdentifierNode(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        return variables.get(this.identifier);
    }
}
