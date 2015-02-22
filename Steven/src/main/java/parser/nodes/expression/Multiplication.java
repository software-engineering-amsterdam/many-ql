package parser.nodes.expression;

import parser.Visitor;
import parser.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Multiplication extends ArithmeticOperator {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
