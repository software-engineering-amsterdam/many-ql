package org.fugazi.ql.ast.expression.logical;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;

public class Or extends Logical {
    
    public Or(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.getLeft().toString() + " || " + this.getRight().toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitOr(this);
    }
}