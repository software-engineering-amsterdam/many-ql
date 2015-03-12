package nl.uva.bromance.ast.conditionals;

/**
 * Created by Robert on 2/22/2015.
 * <p>
 * Stub class.
 */
public interface ContainsExpression {

    Expression getExpression();

    void setExpression(Expression expression);

    void handleExpressionResult(Result result);
}
