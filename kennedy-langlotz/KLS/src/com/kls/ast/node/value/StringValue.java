package com.kls.ast.node.value;

/**
 * Created by Timon on 07.03.2015.
 */
public class StringValue extends AValue<String> {

    public StringValue(String value) {
        super(value.substring(1, value.length()-2), Type.STRING);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
