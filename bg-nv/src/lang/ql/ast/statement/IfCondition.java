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
    List<Statement> thenStatements;
    List<Statement> elseStatements;

    public IfCondition(Expression expression, List<Statement> thenStatements, List<Statement> elseStatements)
    {
        this.expression = expression;
        this.thenStatements = thenStatements;
        this.elseStatements = elseStatements;
    }
}
