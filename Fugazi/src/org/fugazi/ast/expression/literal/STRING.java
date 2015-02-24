package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class STRING extends Literal {

    private final String value;
    private final Class returnedType;

    public STRING(String _value, int _lineNum) {
        super(_lineNum);

        this.value = _value;
        this.returnedType = StringType.class;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}
