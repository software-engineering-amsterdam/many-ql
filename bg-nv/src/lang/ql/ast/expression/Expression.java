package lang.ql.ast.expression;

import lang.ql.ast.AstNode;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Expression extends AstNode
{
    public abstract Expression getValue();
}
