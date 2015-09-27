package nl.uva.bromance.QL.expressions.unary;


import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
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
    public Primitive evaluate(SymbolTable s) {
        return s.lookup(identifier);
    }

    //TODO:Lookup table is build top down. So if a question actually is defined but not before a reference to it is made this error is also trhown. Feature or bug?
    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        Primitive lookup = s.lookup(identifier);
        if(lookup == null)
        {
            exceptions.add(new TypeCheckingError("Identifier: \""+identifier+"\" points to non existing question/calculation, see line: "+getLineNumber()));
        }
        return lookup;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
    }
}
