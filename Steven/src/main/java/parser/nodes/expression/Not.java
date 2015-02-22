package parser.nodes.expression;

import typeChecker.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Not extends UnaryExpression {

    public Not(Expression operand) {
        super(operand);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
