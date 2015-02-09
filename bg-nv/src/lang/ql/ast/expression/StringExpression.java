package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class StringExpression extends Expression
{
    private String value;

    public StringExpression(String value)
    {
        this.value = value;
    }

    @Override
    public Expression getValue()
    {
        return this;
    }
}
