package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.StringType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class ID extends Literal {

    private final String name;
    private final List<Type> supportedTypes;

    public ID(String _name) {
        this.name = _name;
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new StringType());
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

