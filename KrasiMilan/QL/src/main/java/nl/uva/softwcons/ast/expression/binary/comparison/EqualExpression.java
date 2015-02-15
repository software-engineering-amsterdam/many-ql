package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.eval.value.Value;

public class EqualExpression extends BinaryExpression {

    public EqualExpression(Expression left, Expression right) {
        super(left, right);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
