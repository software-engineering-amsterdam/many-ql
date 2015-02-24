package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.StringType;
import org.fugazi.ast.type.Type;


public class STRING extends Literal {

    private final String value;

    public STRING(String _value) {
        super();

        this.value = _value;
    }
    public STRING(String _value, int _lineNum) {
        super(_lineNum);

        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public Type getReturnedType() {
        return new StringType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}
