package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.StringType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class STRING extends Literal {

    private final String value;
    private final List<Type> supportedTypes;

    public STRING(String _value) {
        this.value = _value;
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new StringType());
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}
