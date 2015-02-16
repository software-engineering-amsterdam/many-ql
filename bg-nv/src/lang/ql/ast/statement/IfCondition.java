package lang.ql.ast.statement;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;
import lang.ql.ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void visit(Visitor visitor) { visitor.visit(this); }

    public Iterable<? extends AstNode> getChildren()
    {
        List<AstNode> result = new ArrayList<AstNode>();
        result.add(this.expression);
        result.addAll(this.statements);
        return result;
    }
}
