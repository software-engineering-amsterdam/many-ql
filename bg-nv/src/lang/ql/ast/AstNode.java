package lang.ql.ast;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class AstNode
{
    public Iterable<? extends AstNode> getChildren()
    {
        return null;
    }

    public abstract void visit(Visitor visitor);
}
