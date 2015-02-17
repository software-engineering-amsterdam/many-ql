package lang.ql.ast.statement;

import lang.ql.ast.expression.Expression;
import lang.ql.semantics.Visitor;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class IfCondition extends Statement
{
    private Expression expression;
    private List<Statement> statements;

    public IfCondition(Expression expression, List<Statement> statements)
    {
        this.expression = expression;
        this.statements = statements;
    }

    public Expression getExpression()
    {
        return this.expression;
    }

    public List<Statement> getStatements()
    {
        return this.statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
