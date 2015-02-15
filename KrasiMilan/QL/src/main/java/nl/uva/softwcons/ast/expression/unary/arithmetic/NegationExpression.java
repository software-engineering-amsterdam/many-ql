package nl.uva.softwcons.ast.expression.unary.arithmetic;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;

public class NegationExpression extends UnaryExpression {

    public NegationExpression(Expression expr) {
        super(expr);
    }

}
