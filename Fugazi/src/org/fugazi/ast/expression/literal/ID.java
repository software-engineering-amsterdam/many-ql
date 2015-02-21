package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class ID extends Literal {

    private final String name;
    private final Type type;
    private final List<Class> supportedTypes;

    public ID(String _name, Type _type) {
        this.name = _name;
        this.type = _type;
        this.supportedTypes = new ArrayList<Class>();
        if (this.type != null) {
            // without this check would crash
            // for undefined variables
            this.supportedTypes.add(type.getClass());
        }
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

