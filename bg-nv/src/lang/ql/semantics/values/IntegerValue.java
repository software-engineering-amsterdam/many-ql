package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class IntegerValue extends Value<Integer>
{
    public IntegerValue(Integer value)
    {
        super(value);
    }

    public Value add(Value v)
    {
        return v.addInteger(this);
    }

    @Override
    public Value addInteger(IntegerValue value)
    {
        return new IntegerValue(this.getValue() + value.getValue());
    }

    @Override
    public Value sub(Value v)
    {
        return v.subInteger(this);
    }

    @Override
    public Value subInteger(IntegerValue v)
    {
        return new IntegerValue(v.getValue() - this.getValue());
    }

    @Override
    public Value mul(Value v)
    {
        return v.mulInteger(this);
    }

    @Override
    public Value mulInteger(IntegerValue v)
    {
        return new IntegerValue(this.getValue() * v.getValue());
    }

    @Override
    public Value div(Value v)
    {
        return v.divInteger(this);
    }

    @Override
    public Value divInteger(IntegerValue v)
    {
        return new IntegerValue(v.getValue() / this.getValue());
    }

    @Override
    public Value gt(Value v)
    {
        return v.gtInteger(this);
    }

    @Override
    public Value gtInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() > this.getValue());
    }

    @Override
    public Value lt(Value v)
    {
        return v.ltInteger(this);
    }

    @Override
    public Value ltInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() < this.getValue());
    }

    @Override
    public Value gtEqu(Value v)
    {
        return v.gtEquInteger(this);
    }

    @Override
    public Value gtEquInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() >= this.getValue());
    }

    @Override
    public Value ltEqu(Value v)
    {
        return v.ltEquInteger(this);
    }

    @Override
    public Value ltEquInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() <= this.getValue());
    }

    @Override
    public Value equ(Value v)
    {
        return v.equInteger(this);
    }

    @Override
    public Value equInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() == this.getValue());
    }

    @Override
    public Value notEqu(Value v)
    {
        return v.notEquInteger(this);
    }

    @Override
    public Value notEquInteger(IntegerValue v)
    {
        return new BooleanValue(v.getValue() != this.getValue());
    }

    @Override
    public Value neg()
    {
        return this.negInteger();
    }

    @Override
    public Value negInteger()
    {
        return new IntegerValue(this.getValue() * -1);
    }

    @Override
    public Value pos()
    {
        return this.posInteger();
    }

    @Override
    public Value posInteger()
    {
        return new IntegerValue(this.getValue());
    }
}