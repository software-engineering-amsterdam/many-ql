package org.fugazi.ql.ast.expression.literal;

import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;


public class STRING extends Literal {

    private final String value;

    public STRING(String _value) {
        super();

        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public Type getReturnedType(QLFormDataStorage _formData) {
        return new StringType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}
