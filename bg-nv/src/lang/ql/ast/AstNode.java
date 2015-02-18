package lang.ql.ast;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class AstNode
{
    public abstract void accept(Visitor visitor);
}
