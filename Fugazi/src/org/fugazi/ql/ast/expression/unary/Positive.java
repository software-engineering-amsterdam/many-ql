package org.fugazi.ql.ast.expression.unary;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;

public class Positive extends Unary {

    public Positive(Expression _expr) {
        super(_expr);
    }
    
    public Positive(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);
    }

    @Override
    public String toString() {
        return "+ " + this.getExpr().toString();
    }

    @Override
    public Type getReturnedType() {
        return new IntType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}