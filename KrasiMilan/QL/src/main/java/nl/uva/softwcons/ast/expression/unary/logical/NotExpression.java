package nl.uva.softwcons.ast.expression.unary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;
import nl.uva.softwcons.eval.value.Value;

public class NotExpression extends UnaryExpression {

    public NotExpression(Expression expr) {
        super(expr);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
