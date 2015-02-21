package parser.ast.nodes.expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Or extends BinaryExpression {
    public Or(Expression left, Expression right) {
        super(left, right);
    }
}
