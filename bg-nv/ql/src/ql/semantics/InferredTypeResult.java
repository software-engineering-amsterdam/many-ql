package ql.semantics;

import ql.ast.type.Type;
import ql.semantics.errors.Messages;

/**
 * Created by bore on 16/03/15.
 */
public class InferredTypeResult
{
    private final Type type;
    private final Messages messages;

    public InferredTypeResult(Type type, Messages messages)
    {
        this.type = type;
        this.messages = messages;
    }

    public Type getType()
    {
        return this.type;
    }

    public Messages getMessages()
    {
        return this.messages;
    }

    public boolean containsErrors()
    {
        return this.messages.containsError();
    }
}
