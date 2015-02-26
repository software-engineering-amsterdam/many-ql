package nl.uva.softwcons.ast.expression.unary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;

public class Not extends UnaryExpression {

    public Not(Expression expr) {
        super(expr);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
