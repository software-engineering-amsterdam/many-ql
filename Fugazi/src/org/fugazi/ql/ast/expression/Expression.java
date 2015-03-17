package org.fugazi.ql.ast.expression;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

public abstract class Expression extends AbstractASTNode {

    public Expression() {
        super();
    }

    public abstract String toString();

    public abstract Type getReturnedType(QLFormDataStorage _formData);

    public abstract <T> T accept(IExpressionVisitor<T> visitor);

    public boolean isExpressionOfTypeBool(QLFormDataStorage _formData) {
        return this.isExpressionOfType(_formData, new BoolType());
    }

    public boolean isExpressionOfTypeInt(QLFormDataStorage _formData) {
        return this.isExpressionOfType(_formData, new IntType());
    }

    public boolean isExpressionOfTypeString(QLFormDataStorage _formData) {
        return this.isExpressionOfType(_formData, new StringType());
    }

    public boolean isExpressionOfType(QLFormDataStorage _formData, Type type) {
        return this.getReturnedType(_formData).equals(type);
    }
}