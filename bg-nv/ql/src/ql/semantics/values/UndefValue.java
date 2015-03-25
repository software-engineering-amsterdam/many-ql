package ql.semantics.values;

/**
 * Created by bore on 24/02/15.
 */
public class UndefValue extends Value<Void>
{
    public UndefValue()
    {
        super(null);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    public Boolean isUndefined()
    {
        return true;
    }

    @Override
    public Value add(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value addInteger(IntValue v)
    {
        return new UndefValue();
    }
    
    @Override
    public Value addDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value addString(StrValue v)
    {
        return new UndefValue();
    }
    
    @Override
    public Value sub(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value subInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value subDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value mul(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value mulInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value mulDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value div(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value divInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value divDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value neg()
    {
        return new UndefValue();
    }

    @Override
    public Value negInteger()
    {
        return new UndefValue();
    }

    @Override
    public Value negDecimal()
    {
        return new UndefValue();
    }

    @Override
    public Value pos()
    {
        return new UndefValue();
    }

    @Override
    public Value posInteger()
    {
        return new UndefValue();
    }

    @Override
    public Value posDecimal()
    {
        return new UndefValue();
    }

    @Override
    public Value not()
    {
        return new UndefValue();
    }

    @Override
    public Value gt(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value gtInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value gtDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value lt(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value ltInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value ltDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value gtEqu(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value gtEquInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value gtEquDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value ltEqu(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value ltEquInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value ltEquDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value equ(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value equInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value equDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value equString(StrValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value equBoolean(BoolValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value notEqu(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value notEquInteger(IntValue v)
    {
        return new UndefValue();
    }

    @Override
     public Value notEquDecimal(DecValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value notEquString(StrValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value notEquBoolean(BoolValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value and(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value andBoolean(BoolValue v)
    {
        return new UndefValue();
    }

    @Override
    public Value or(Value v)
    {
        return new UndefValue();
    }

    @Override
    public Value orBoolean(BoolValue v)
    {
        return new UndefValue();
    }

    public <T> T accept(ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
