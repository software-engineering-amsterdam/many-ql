package lang.ql.ast.expression;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class StringExpression extends ConstantExpression<String>
{
    public StringExpression(String value)
    {
        super(value);
    }

    public void visit(Visitor visitor)
    {
        visitor.visit(this);
    }
}
