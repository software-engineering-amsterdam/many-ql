package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.expressions.unary.Primitive;

import java.util.HashMap;

public class SymbolTable {
    HashMap<String, Primitive> table = new HashMap<>();

    public Primitive lookup(String identifier) {
        return table.get(identifier);
    }

    //TODO:Maybe we should consider using tuples, by adding the type of node as well, Form/Question/Calculation
    public void add(String identifier, Primitive t) {
        table.put(identifier, t);
    }
}