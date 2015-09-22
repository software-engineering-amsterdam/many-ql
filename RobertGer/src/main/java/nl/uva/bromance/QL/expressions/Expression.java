package nl.uva.bromance.QL.expressions;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

public abstract class Expression extends QLNode implements Evaluable {
    public Expression(int ln) {
        super(ln);
    }
}
