package parser.ast.nodes.expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Not extends Expression {
    private final Expression expression;

    public Not(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
