package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;

public class NotEqualExpression extends BinaryExpression {

    public NotEqualExpression(Expression left, Expression right) {
        super(left, right);
    }

}
