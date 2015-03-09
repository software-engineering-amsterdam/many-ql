package nl.uva.softwcons.ql.eval.value;

public class StringValue extends Value {

    private final String stringValue;

    public StringValue(String value) {
        this.stringValue = value;
    }

    @Override
    public String asString() {
        return stringValue;
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.stringValue != null && this.stringValue.equals(otherValue.asString()));
    }

    @Override
    public String getValue() {
        return this.stringValue;
    }

    @Override
    public Value getValueFromString(String string) {
        // TODO Auto-generated method stub
        return new StringValue(string);
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
