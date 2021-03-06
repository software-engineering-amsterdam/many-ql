package org.fugazi.ql.ast.expression.literal;

import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;

public class BOOL extends Literal {

    private final Boolean value;

    public BOOL(Boolean _value) {
        super();

        this.value = _value;
    }

    public Boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public Type getReturnedType(QLFormDataStorage _formData) {
        return new BoolType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitBOOL(this);
    }
}