package ql.semantics.values;

/**
 * Created by bore on 24/02/15.
 */
public class UndefValue extends Value<Void>
{
    private static final UndefValue undefValue = new UndefValue();
    
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
        return undefValue;
    }

    @Override
    public Value addInteger(IntValue v)
    {
        return undefValue;
    }
    
    @Override
    public Value addDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value addString(StrValue v)
    {
        return undefValue;
    }
    
    @Override
    public Value sub(Value v)
    {
        return undefValue;
    }

    @Override
    public Value subInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value subDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value mul(Value v)
    {
        return undefValue;
    }

    @Override
    public Value mulInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value mulDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value div(Value v)
    {
        return undefValue;
    }

    @Override
    public Value divInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value divDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value neg()
    {
        return undefValue;
    }

    @Override
    public Value negInteger()
    {
        return undefValue;
    }

    @Override
    public Value negDecimal()
    {
        return undefValue;
    }

    @Override
    public Value pos()
    {
        return undefValue;
    }

    @Override
    public Value posInteger()
    {
        return undefValue;
    }

    @Override
    public Value posDecimal()
    {
        return undefValue;
    }

    @Override
    public Value not()
    {
        return undefValue;
    }

    @Override
    public Value gt(Value v)
    {
        return undefValue;
    }

    @Override
    public Value gtInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value gtDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value lt(Value v)
    {
        return undefValue;
    }

    @Override
    public Value ltInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value ltDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value gtEqu(Value v)
    {
        return undefValue;
    }

    @Override
    public Value gtEquInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value gtEquDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value ltEqu(Value v)
    {
        return undefValue;
    }

    @Override
    public Value ltEquInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value ltEquDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value equ(Value v)
    {
        return undefValue;
    }

    @Override
    public Value equInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
    public Value equDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value equString(StrValue v)
    {
        return undefValue;
    }

    @Override
    public Value equBoolean(BoolValue v)
    {
        return undefValue;
    }

    @Override
    public Value notEqu(Value v)
    {
        return undefValue;
    }

    @Override
    public Value notEquInteger(IntValue v)
    {
        return undefValue;
    }

    @Override
     public Value notEquDecimal(DecValue v)
    {
        return undefValue;
    }

    @Override
    public Value notEquString(StrValue v)
    {
        return undefValue;
    }

    @Override
    public Value notEquBoolean(BoolValue v)
    {
        return undefValue;
    }

    @Override
    public Value and(Value v)
    {
        return undefValue;
    }

    @Override
    public Value andBoolean(BoolValue v)
    {
        return undefValue;
    }

    @Override
    public Value or(Value v)
    {
        return undefValue;
    }

    @Override
    public Value orBoolean(BoolValue v)
    {
        return undefValue;
    }

    public <T> T accept(ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
