package com.klq.ast.impl.expr;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.value.Value;

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
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        return variables.get(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IdentifierNode){
            String objId = ((IdentifierNode)obj).identifier;
            return this.identifier.equals(objId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
