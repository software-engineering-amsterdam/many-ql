package com.klq.typechecker.error;

import com.klq.ast.impl.Location;
import com.klq.ast.impl.Type;

/**
 * Created by juriaan on 9-3-15.
 */
public class InvalidTypeForOperator extends AError {
    public InvalidTypeForOperator(Location location, Type type, String operator) {
        super(6, true, String.format("The %s operator cannot take a value of type %s", operator, type), location);
    }
}
