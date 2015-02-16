package nl.uva.softwcons.ast.expression.binary.arithmetic;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;

public class SubstractionExpression extends BinaryExpression {

    public SubstractionExpression(Expression left, Expression right) {
        super(left, right);
    }

}
