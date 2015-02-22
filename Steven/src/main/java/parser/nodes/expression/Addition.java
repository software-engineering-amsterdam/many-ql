package parser.nodes.expression;

import typeChecker.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Addition extends BinaryExpression {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
