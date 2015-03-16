package org.fugazi.ql.ast.expression.unary;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;

public class Not extends Unary {
    
    public Not(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "! " + this.getExpr().toString();
    }

    public Type getReturnedType(QLFormDataStorage _formData) {
        return new BoolType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}