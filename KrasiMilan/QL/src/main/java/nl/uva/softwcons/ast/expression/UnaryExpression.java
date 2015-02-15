package nl.uva.softwcons.ast.expression;

import nl.uva.softwcons.eval.Operator;
import nl.uva.softwcons.eval.value.Value;

public class UnaryExpression extends Expression {

    private Expression expression;
    private Operator operator;

    public UnaryExpression(Expression expr, Operator op) {
        this.expression = expr;
        this.operator = op;
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
