package com.klq.typechecker.error;

import com.klq.ast.impl.Location;
import com.klq.ast.impl.expr.literal.IdentifierNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class NotUniqueID extends AError{

    public NotUniqueID(IdentifierNode id, Location location) {
        super(1, true, String.format("The question identifier: \"%s\" is not unique", id.getIdentifier()), location);
    }



}
