package com.klq.ast.impl.value;

/**
 * Created by Timon on 03.03.2015.
 */
public class IdentifierValue extends Value<String> {

    public IdentifierValue(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
