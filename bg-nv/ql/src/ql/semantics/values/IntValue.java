package ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class IntValue extends Value<Integer>
{
    public IntValue(Integer value)
    {
        super(value);
    }

    public Value add(Value v)
    {
        return v.addInteger(this);
    }

    @Override
    public Value addInteger(IntValue value)
    {
        return new IntValue(this.getValue() + value.getValue());
    }

    @Override
    public Value sub(Value v)
    {
        return v.subInteger(this);
    }

    @Override
    public Value subInteger(IntValue v)
    {
        return new IntValue(v.getValue() - this.getValue());
    }

    @Override
    public Value mul(Value v)
    {
        return v.mulInteger(this);
    }

    @Override
    public Value mulInteger(IntValue v)
    {
        return new IntValue(this.getValue() * v.getValue());
    }

    @Override
    public Value div(Value v)
    {
        return v.divInteger(this);
    }

    @Override
    public Value divInteger(IntValue v)
    {
        return new IntValue(v.getValue() / this.getValue());
    }

    @Override
    public Value gt(Value v)
    {
        return v.gtInteger(this);
    }

    @Override
    public Value gtInteger(IntValue v)
    {
        return new BoolValue(v.getValue() > this.getValue());
    }

    @Override
    public Value lt(Value v)
    {
        return v.ltInteger(this);
    }

    @Override
    public Value ltInteger(IntValue v)
    {
        return new BoolValue(v.getValue() < this.getValue());
    }

    @Override
    public Value gtEqu(Value v)
    {
        return v.gtEquInteger(this);
    }

    @Override
    public Value gtEquInteger(IntValue v)
    {
        return new BoolValue(v.getValue() >= this.getValue());
    }

    @Override
    public Value ltEqu(Value v)
    {
        return v.ltEquInteger(this);
    }

    @Override
    public Value ltEquInteger(IntValue v)
    {
        return new BoolValue(v.getValue() <= this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equInteger(this);
    }

    @Override
    public Value equInteger(IntValue v)
    {
        return new BoolValue(v.getValue() == this.getValue());
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquInteger(this);
    }

    @Override
    public Value notEquInteger(IntValue v)
    {
        return new BoolValue(v.getValue() != this.getValue());
    }

    @Override
    public Value neg()
    {
        return this.negInteger();
    }

    @Override
    public Value negInteger()
    {
        return new IntValue(this.getValue() * -1);
    }

    @Override
    public Value pos()
    {
        return this.posInteger();
    }

    @Override
    public Value posInteger()
    {
        return new IntValue(this.getValue());
    }

    @Override
    public Value promoteTo(Value v)
    {
        return v.promoteInt(this);
    }

    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}