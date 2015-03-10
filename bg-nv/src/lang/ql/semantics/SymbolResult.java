package lang.ql.semantics;

import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Messages;

import java.util.List;

/**
 * Created by bore on 23/02/15.
 */
public class SymbolResult
{
    private SymbolTable table;
    private Messages messages;

    public SymbolResult(SymbolTable table, Messages messages)
    {
        this.table = table;
        this.messages = messages;
    }

    public SymbolTable getSymbolTable()
    {
        return this.table;
    }

    public Messages getMessages()
    {
        return this.messages;
    }
}
