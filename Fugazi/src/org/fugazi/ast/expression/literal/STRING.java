package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class STRING extends Literal {

    private final String value;
    private final List<Class> supportedTypes;

    public STRING(String _value, int _lineNum) {
        super(_lineNum);

        this.value = _value;
        Class stringTypeClass = StringType.class;
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(stringTypeClass);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}
