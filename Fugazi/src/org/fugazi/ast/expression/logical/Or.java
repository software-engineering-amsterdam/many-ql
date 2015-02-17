package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;

public class Or extends Logical {

    public Or(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        System.out.println("lalalal");
//        return "lalalala";
        System.out.println(this.left);
        System.out.println(this.right.toString());
        return this.left.toString() + " || " + this.right.toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitOr(this);
    }
}