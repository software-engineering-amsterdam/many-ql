package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.unary.Primitive;

public class LookupValue
{
    private Primitive type;
    private QLNode node;

    public  LookupValue(Primitive type, QLNode node)
    {
        this.type = type;
        this.node = node;
    }

    public Primitive getType()
    {
        return type;
    }

    public QLNode getNode()
    {
        return node;
    }
}
