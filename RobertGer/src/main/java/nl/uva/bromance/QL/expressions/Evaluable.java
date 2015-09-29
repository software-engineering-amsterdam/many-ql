package nl.uva.bromance.QL.expressions;

import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public interface Evaluable
{
    Primitive evaluate(SymbolTable s);
}
