package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class StringExpr extends ConstantExpr<String>
{
    public StringExpr(String value)
    {
        super(value);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
