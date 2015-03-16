package nl.uva.softwcons.ql.ui.converter;

import nl.uva.softwcons.ql.eval.value.Value;

/**
 * ValueConverter defines conversion behavior between values and objects. The
 * type of objects and formats of values are defined by the subclasses of
 * ValueConverter.
 */
public interface ValueConverter<T> {
    /**
     * Converts the object provided to a value object. Type of the returned
     * value is defined by the specific converter.
     * 
     * @return a value created from the object passed in.
     */
    public abstract Value toValue(T value);

    /**
     * Converts the value provided into an object defined by the specific
     * converter.
     * 
     * @return an object representation of the value passed in.
     */
    public abstract T fromValue(Value value);
}
