package nl.uva.bromance.QL.expressions.unary;


import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class Variable extends UnaryExpression {

    public String identifier;

    public Variable(String identifier, int ln) {
        super(ln);
        this.identifier = identifier;
    }

    @Override
    public Primitive evaluate() {
        return null; //TODO: Look up the identifier of this variabel in the lookuptable.
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        Primitive lookup = s.lookup(identifier);
        if(lookup == null)
        {
            exceptions.add(new TypeCheckingError("Identifier: \""+identifier+"\" points to non existing question/calculation, see line: "+getLineNumber()));
        }
        return lookup;
    }
}
