package ql.semantics.values;

import ql.ast.type.IntType;
import ql.ast.type.Type;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by bore on 16/02/15.
 */
public class DecValue extends Value<BigDecimal>
{
    public DecValue(BigDecimal value)
    {
        super(value);
    }

    public Value add(Value v)
    {
        return v.addDecimal(this);
    }

    @Override
    public Value addDecimal(DecValue value)
    {
        return new DecValue(value.getValue().add(this.getValue()));
    }

    @Override
    public Value sub(Value v)
    {
        return v.subDecimal(this);
    }

    @Override
    public Value subDecimal(DecValue v)
    {
        return new DecValue(v.getValue().subtract(this.getValue()));
    }

    @Override
    public Value mul(Value v)
    {
        return v.mulDecimal(this);
    }

    @Override
    public Value mulDecimal(DecValue v)
    {
        return new DecValue(v.getValue().multiply(this.getValue()));
    }

    @Override
    public Value div(Value v)
    {
        return v.divDecimal(this);
    }

    @Override
    public Value divDecimal(DecValue v)
    {
        return new DecValue(v.getValue().divide(this.getValue(), new MathContext(6, RoundingMode.FLOOR)));
    }

    @Override
    public Value gt(Value v)
    {
        return v.gtDecimal(this);
    }

    @Override
    public Value gtDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) > 0);
    }

    @Override
    public Value lt(Value v)
    {
        return v.ltDecimal(this);
    }

    @Override
    public Value ltDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) < 0);
    }

    @Override
    public Value gtEqu(Value v)
    {
        return v.gtEquDecimal(this);
    }

    @Override
    public Value gtEquDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) >= 0);
    }

    @Override
    public Value ltEqu(Value v)
    {
        return v.ltEquDecimal(this);
    }

    @Override
    public Value ltEquDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) <= 0);
    }

    @Override
    public Value equ(Value v)
    {
        return v.equDecimal(this);
    }

    @Override
    public Value equDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) == 0);
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquDecimal(this);
    }

    @Override
    public Value notEquDecimal(DecValue v)
    {
        return new BoolValue(v.getValue().compareTo(this.getValue()) != 0);
    }

    @Override
    public Value neg()
    {
        return this.negDecimal();
    }

    @Override
    public Value negDecimal()
    {
        return new DecValue(this.getValue().negate());
    }

    @Override
    public Value pos()
    {
        return this.posDecimal();
    }

    @Override
    public Value posDecimal()
    {
        return new DecValue(this.getValue());
    }

    @Override
    public Value promoteInt(IntValue v)
    {
        return new DecValue(new BigDecimal(v.getValue().toString()));
    }

    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
