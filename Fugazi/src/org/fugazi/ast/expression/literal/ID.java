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
    private final List<Class> supportedTypes;

    public ID(String _name) {
        this.name = _name;
        Class stringTypeClass = new StringType().getClass();
        Class intTypeClass = new IntType().getClass();
        Class boolTypeClass = new BoolType().getClass();
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(stringTypeClass);
        this.supportedTypes.add(intTypeClass);
        this.supportedTypes.add(boolTypeClass);
    }

    public String getName() {
        return this.name;
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

