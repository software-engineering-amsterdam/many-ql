package ql.semantics.values;

import ql.ast.type.IntType;

/**
 * Created by bore on 16/02/15.
 */

public abstract class Value<T>
{
    private T value;

    public Boolean isUndefined()
    {
        return false;
    }

    public Value(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        return this.value.toString();
    }

    public Value add(Value v)
    {
        throw new IllegalStateException();
    }

    public Value addInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value addDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value addString(StrValue v)
    {
        throw new IllegalStateException();
    }

    public Value sub(Value v)
    {
        throw new IllegalStateException();
    }

    public Value subInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value subDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value mul(Value v)
    {
        throw new IllegalStateException();
    }

    public Value mulInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value mulDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value div(Value v)
    {
        throw new IllegalStateException();
    }

    public Value divInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value divDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value neg()
    {
        throw new IllegalStateException();
    }

    public Value negInteger()
    {
        throw new IllegalStateException();
    }

    public Value negDecimal()
    {
        throw new IllegalStateException();
    }

    public Value pos()
    {
        throw new IllegalStateException();
    }

    public Value posInteger()
    {
        throw new IllegalStateException();
    }

    public Value posDecimal()
    {
        throw new IllegalStateException();
    }

    public Value not()
    {
        throw new IllegalStateException();
    }

    public Value gt(Value v)
    {
        throw new IllegalStateException();
    }

    public Value gtInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value lt(Value v)
    {
        throw new IllegalStateException();
    }

    public Value ltInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value gtEquInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value gtEquDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value ltEquInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value ltEquDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value equ(Value v)
    {
        throw new IllegalStateException();
    }

    public Value equInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value equDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value equString(StrValue v)
    {
        throw new IllegalStateException();
    }

    public Value equBoolean(BoolValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEqu(Value v)
    {
        throw new IllegalStateException();
    }

    public Value notEquInteger(IntValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquDecimal(DecValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquString(StrValue v)
    {
        throw new IllegalStateException();
    }

    public Value notEquBoolean(BoolValue v)
    {
        throw new IllegalStateException();
    }

    public Value and(Value v)
    {
        throw new IllegalStateException();
    }

    public Value andBoolean(BoolValue v)
    {
        throw new IllegalStateException();
    }

    public Value or(Value v)
    {
        throw new IllegalStateException();
    }

    public Value orBoolean(BoolValue v)
    {
        throw new IllegalStateException();
    }

    public Value promoteTo(Value v)
    {
        return this;
    }

    protected Value promoteInt(IntValue v)
    {
        return v;
    }

    public abstract <T> T accept (ValueVisitor<T> visitor);
}
