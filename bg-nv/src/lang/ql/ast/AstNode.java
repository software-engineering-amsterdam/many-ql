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

//    public String toString()
//    {
//        StringBuilder builder = new StringBuilder();
//        builder.append(getClass().getSimpleName());
//        builder.append('[');
//
//        Iterable<? extends AstNode> children = this.getChildren();
//        if (children != null)
//        {
//            for (AstNode child : this.getChildren())
//            {
//                builder.append(child.toString());
//            }
//        }
//
//        builder.append(']');
//        return builder.toString();
//    }
}
