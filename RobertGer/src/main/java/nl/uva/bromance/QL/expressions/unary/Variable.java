package nl.uva.bromance.QL.expressions.unary;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import java.util.List;

public class Variable extends UnaryExpression
{
    public String identifier;

    public Variable(String identifier, int ln)
    {
        super(ln);
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return this.identifier;
    }

    @Override
    public Primitive evaluate(SymbolTable s)
    {
        return s.lookup(identifier);
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions)
    {
        Primitive lookup = s.lookup(identifier);
        if(lookup == null)
            exceptions.add(new TypeCheckingError("Identifier: \""+identifier+"\" points to non existing question/calculation, see line: "+getLineNumber(), TypeCheckingError.Type.ERROR));

        return lookup;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor)
    {
        visitor.visit(this);
        for (QLNode child : this.getChildren())
        {
            child.accept(visitor);
        }
    }
}
