package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.expressions.unary.Primitive;

import java.util.Map;

public class Reference {

    private String identifier;
    private int line;

    public Reference(String identifier, int line)
    {
        this.identifier = identifier;
        this.line = line;
    }

    private boolean isReferenceInMap(Map<String, Primitive> map)
    {
        boolean result = false;
        if(map.get(this.identifier) != null)
        {
            result = true;
        }
        return result;
    }
}
