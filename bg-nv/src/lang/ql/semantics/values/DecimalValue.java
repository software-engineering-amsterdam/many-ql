package lang.ql.semantics.values;

import java.math.BigInteger;

/**
 * Created by bore on 16/02/15.
 */
public class DecimalValue extends Value<BigInteger>
{
    public DecimalValue(BigInteger value)
    {
        super(value);
    }

    public static DecimalValue getDefaultValue()
    {
        return new DecimalValue(new BigInteger("0"));
    }

    @Override
    public Value unaryMinus()
    {
        return this.unaryMinusDecimal();
    }

    @Override
    public Value unaryMinusDecimal()
    {
        return new DecimalValue(this.getValue().negate());
    }
}
