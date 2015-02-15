package nl.uva.softwcons.ast.expression.unary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;

public class NotExpression extends UnaryExpression {

    public NotExpression(Expression expr) {
        super(expr);
    }

}
