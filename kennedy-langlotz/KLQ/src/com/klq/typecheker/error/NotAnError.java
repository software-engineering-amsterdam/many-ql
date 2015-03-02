package com.klq.typecheker.error;

import com.klq.ast.ANode;
import com.klq.logic.question.Type;

/**
 * Created by Juriaan on 1-3-2015.
 */
//TODO This is a class with which I can cheat through the visitor. Pretty sure this is not how i should do it, confirm with teachers
public class NotAnError extends AError {
    private Type primitiveType;
    public NotAnError(ANode node, Type primitiveType){
        super(-1, false, "There is no error here", node.getLoc());
        this.primitiveType = primitiveType;
    }

    public Type getPrimitiveType() {
        return primitiveType;
    }
}
