package nl.uva.softwcons.ast.expression.binary.arithmetic;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.eval.value.Value;

public class AdditionExpression extends BinaryExpression {

    public AdditionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
