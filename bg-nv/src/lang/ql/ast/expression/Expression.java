package lang.ql.ast.expression;

import lang.ql.ast.AstNode;
import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Expression extends AstNode
{
    public abstract ConstantExpression getValue();

    public void visit(Visitor visitor) { visitor.visit(this); }
}
