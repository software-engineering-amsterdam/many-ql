package lang.ql.ast.expression;

import java.math.BigInteger;
import java.util.Currency;

/**
 * Created by bore on 10/02/15.
 */
public class DecimalExpression extends ConstantExpression<BigInteger>
{
    public DecimalExpression(BigInteger value)
    {
        super(value);
    }
}
