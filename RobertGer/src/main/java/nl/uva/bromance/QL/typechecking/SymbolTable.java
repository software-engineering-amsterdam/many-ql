package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import java.util.HashMap;

public class SymbolTable
{
    HashMap<String, LookupValue> table = new HashMap<>();

    public Primitive lookup(String identifier)
    {
        return (table.get(identifier) == null) ? null : table.get(identifier).getType();
    }

    public QLNode lookupNode(String identifier)
    {
        return (table.get(identifier) == null) ? null : table.get(identifier).getNode();
    }

    public void add(String identifier, Primitive t, QLNode node)
    {
        table.put(identifier, new LookupValue(t, node));
    }
}