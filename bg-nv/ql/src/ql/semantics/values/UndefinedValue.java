package ql.semantics.values;

/**
 * Created by bore on 24/02/15.
 */
public class UndefinedValue extends Value<Void>
{
    public UndefinedValue()
    {
        super(null);
    }

    @Override
    public String toString()
    {
        return "Undefined Value";
    }

    @Override
    public Boolean isUndefined()
    {
        return true;
    }

    @Override
    public Value add(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value addInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }
    
    @Override
    public Value addDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value addString(StringValue v)
    {
        return new UndefinedValue();
    }
    
    @Override
    public Value sub(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value subInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value subDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value mul(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value mulInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value mulDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value div(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value divInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value divDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value neg()
    {
        return new UndefinedValue();
    }

    @Override
    public Value negInteger()
    {
        return new UndefinedValue();
    }

    @Override
    public Value negDecimal()
    {
        return new UndefinedValue();
    }

    @Override
    public Value pos()
    {
        return new UndefinedValue();
    }

    @Override
    public Value posInteger()
    {
        return new UndefinedValue();
    }

    @Override
    public Value posDecimal()
    {
        return new UndefinedValue();
    }

    @Override
    public Value not()
    {
        return new UndefinedValue();
    }

    @Override
    public Value gt(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value gtInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value gtDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value lt(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value ltInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value ltDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value gtEqu(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value gtEquInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value gtEquDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value ltEqu(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value ltEquInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value ltEquDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value equ(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value equInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value equDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value equString(StringValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value equBoolean(BooleanValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value notEqu(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value notEquInteger(IntegerValue v)
    {
        return new UndefinedValue();
    }

    @Override
     public Value notEquDecimal(DecimalValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value notEquString(StringValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value notEquBoolean(BooleanValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value and(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value andBoolean(BooleanValue v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value or(Value v)
    {
        return new UndefinedValue();
    }

    @Override
    public Value orBoolean(BooleanValue v)
    {
        return new UndefinedValue();
    }

    public <T> T accept(ValueVisitor<T> visitor)
    {
        throw new IllegalStateException("Visiting undefined value");
    }
}
