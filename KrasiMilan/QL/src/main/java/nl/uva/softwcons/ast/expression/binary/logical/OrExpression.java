package nl.uva.softwcons.ast.expression.binary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;

public class OrExpression extends BinaryExpression {

    public OrExpression(Expression left, Expression right) {
        super(left, right);
    }

}
