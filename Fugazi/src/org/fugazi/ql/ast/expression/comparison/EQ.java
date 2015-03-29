package org.fugazi.ql.ast.expression.comparison;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EQ extends Comparison {

    public EQ(Expression _left, Expression _right) {
        super(_left, _right);
    }
    
    @Override
    public String toString() {
        return this.getLeft().toString() + "==" + this.getRight().toString();
    }

    @Override
    public Type getReturnedType(QLFormDataStorage _formData) {
        return new BoolType();
    }

    public List<Type> getSupportedTypes() {
        List<Type> supportedTypes = new ArrayList<>(
                Arrays.asList(
                        new BoolType(),
                        new IntType(),
                        new StringType()
                )
        );
        return supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitEQ(this);
    }
}