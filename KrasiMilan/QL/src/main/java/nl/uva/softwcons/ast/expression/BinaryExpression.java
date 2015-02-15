package nl.uva.softwcons.ast.expression;

import nl.uva.softwcons.eval.Operator;
import nl.uva.softwcons.eval.value.Value;

public class BinaryExpression extends Expression {

    private Expression leftExpression;
    private Expression rightExpression;
    private Operator operator;

    public BinaryExpression(Expression left, Expression right, Operator op) {
        this.leftExpression = left;
        this.rightExpression = right;
        this.operator = op;
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
