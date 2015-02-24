package lang.ql.semantics.values;

import java.math.BigDecimal;

/**
 * Created by bore on 16/02/15.
 */
public class DecimalValue extends Value<BigDecimal>
{
    public DecimalValue(BigDecimal value)
    {
        super(value);
    }

    public static DecimalValue getDefaultValue()
    {
        return new DecimalValue(new BigDecimal("0"));
    }

    public Value add(Value v)
    {
        return v.addDecimal(this);
    }

    @Override
    public Value addDecimal(DecimalValue value)
    {
        return new DecimalValue(value.getValue().add(this.getValue()));
    }

    @Override
    public Value sub(Value v)
    {
        return v.subDecimal(this);
    }

    @Override
    public Value subDecimal(DecimalValue v)
    {
        return new DecimalValue(v.getValue().subtract(this.getValue()));
    }

    @Override
    public Value mul(Value v)
    {
        return v.mulDecimal(this);
    }

    @Override
    public Value mulDecimal(DecimalValue v)
    {
        return new DecimalValue(v.getValue().multiply(this.getValue()));
    }

    @Override
    public Value div(Value v)
    {
        return v.divDecimal(this);
    }

    @Override
    public Value divDecimal(DecimalValue v)
    {
        return new DecimalValue(v.getValue().divide(this.getValue()));
    }

    @Override
    public Value gt(Value v)
    {
        return v.gtDecimal(this);
    }

    @Override
    public Value gtDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) > 0);
    }

    @Override
    public Value lt(Value v)
    {
        return v.ltDecimal(this);
    }

    @Override
    public Value ltDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) < 0);
    }

    @Override
    public Value gtEqu(Value v)
    {
        return v.gtEquDecimal(this);
    }

    @Override
    public Value gtEquDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) >= 0);
    }

    @Override
    public Value ltEqu(Value v)
    {
        return v.ltEquDecimal(this);
    }

    @Override
    public Value ltEquDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) <= 0);
    }

    @Override
    public Value equ(Value v)
    {
        return v.equDecimal(this);
    }

    @Override
    public Value equDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) == 0);
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquDecimal(this);
    }

    @Override
    public Value notEquDecimal(DecimalValue v)
    {
        return new BooleanValue(v.getValue().compareTo(this.getValue()) != 0);
    }

    @Override
    public Value neg()
    {
        return this.negDecimal();
    }

    @Override
    public Value negDecimal()
    {
        return new DecimalValue(this.getValue().negate());
    }

    @Override
    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
