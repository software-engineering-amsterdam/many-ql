package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;

public class LowerThanExpression extends BinaryExpression {

    public LowerThanExpression(Expression left, Expression right) {
        super(left, right);
    }

}
