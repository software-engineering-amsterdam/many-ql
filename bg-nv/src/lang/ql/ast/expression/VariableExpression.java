package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class VariableExpression extends ConstantExpression<String>
{
    public VariableExpression(String value)
    {
        super(value);
    }
}
