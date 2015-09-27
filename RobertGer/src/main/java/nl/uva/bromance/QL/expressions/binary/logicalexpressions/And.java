package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public class And extends LogicalExpression {
    public And(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s) {
        BooleanPrimitive lhs =  (BooleanPrimitive) this.lhs.evaluate(s);
        BooleanPrimitive rhs =  (BooleanPrimitive) this.rhs.evaluate(s);
        return lhs.and(rhs,getLineNumber());
    }
}
