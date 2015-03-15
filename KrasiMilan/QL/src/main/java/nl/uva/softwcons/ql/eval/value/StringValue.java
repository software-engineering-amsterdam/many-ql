package nl.uva.softwcons.ql.eval.value;

public class StringValue extends Value {
    private final String stringValue;

    public StringValue(final String value) {
        this.stringValue = value;
    }

    @Override
    public String getString() {
        return stringValue;
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return otherValue.isEqualString(this);
    }

    @Override
    public Value isEqualString(final Value otherValue) {
        return new BooleanValue(this.stringValue.equals(otherValue.getString()));
    }

    @Override
    public String getValue() {
        return this.stringValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stringValue == null) ? 0 : stringValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringValue other = (StringValue) obj;
        if (stringValue == null) {
            if (other.stringValue != null)
                return false;
        } else if (!stringValue.equals(other.stringValue))
            return false;
        return true;
    }

}
