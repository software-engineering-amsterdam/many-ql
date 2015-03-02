package lang.ql.semantics;

import lang.ql.semantics.errors.Message;

import java.util.List;

/**
 * Created by bore on 23/02/15.
 */
public class SymbolResult
{
    private SymbolTable table;
    private List<Message> messages;

    public SymbolResult(SymbolTable table, List<Message> messages)
    {
        this.table = table;
        this.messages = messages;
    }

    public SymbolTable getSymbolTable()
    {
        return this.table;
    }

    public List<Message> getMessages()
    {
        return this.messages;
    }
}
