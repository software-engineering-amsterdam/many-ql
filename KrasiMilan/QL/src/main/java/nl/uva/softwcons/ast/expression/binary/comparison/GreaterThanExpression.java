package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;

public class GreaterThanExpression extends BinaryExpression {

    public GreaterThanExpression(Expression left, Expression right) {
        super(left, right);
    }

}
