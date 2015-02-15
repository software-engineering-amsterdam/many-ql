package nl.uva.softwcons.ast.expression.binary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.eval.value.Value;

public class OrExpression extends BinaryExpression {

    public OrExpression(Expression left, Expression right) {
        super(left, right);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
