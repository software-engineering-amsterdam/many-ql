package lang.ql.ast.expression;

import java.util.Date;

/**
 * Created by Nik on 28-02-2015
 */
public class DateExpr extends ConstExpr<Date>
{
    public DateExpr(Date value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return null; //TODO: visitor.visit(this);
    }
}
