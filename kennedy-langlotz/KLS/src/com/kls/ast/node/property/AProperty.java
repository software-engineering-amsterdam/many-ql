package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public abstract class AProperty {
    private final String property;

    public AProperty(String property){
        this.property = property;
    }

    public abstract boolean isCompatibleWith(AValue value);

    public String getProperty() {
        return property;
    }
}
