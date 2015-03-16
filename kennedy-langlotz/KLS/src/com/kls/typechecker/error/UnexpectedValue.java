package com.klq.typechecker.error;

import com.klq.ast.Location;
import com.kls.ast.node.property.AProperty;
import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public class UnexpectedValue extends AError {

    public UnexpectedValue(AProperty property, AValue value, Location location) {
        super(8, true, String.format("Unexpected value %s for property %s",
                value.getValue(), property.getProperty()), location);
    }
}
