package lang.ql.ast.statement;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;
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

    public Iterable<? extends AstNode> getChildren()
    {
        return this.statements;
    }
}
