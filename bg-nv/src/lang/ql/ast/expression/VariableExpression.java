package lang.ql.ast.expression;

import lang.ql.ast.AstNode;
import lang.ql.ast.visitor.Visitor;

import java.util.Collections;

/**
 * Created by bore on 09/02/15.
 */
public class VariableExpression extends Expression
{
    private String id;

    public VariableExpression(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    public void visit(Visitor visitor) { visitor.visit(this); }

    public Iterable<? extends AstNode> getChildren()
    {
        return Collections.emptyList();
    }
}
