package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public class BiggerThan extends LogicalExpression {
    public BiggerThan(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s) {
        NumberPrimitive lhs =  (NumberPrimitive) this.lhs.evaluate(s);
        NumberPrimitive rhs =  (NumberPrimitive) this.rhs.evaluate(s);
        return lhs.biggerThan(rhs, getLineNumber());
    }
}
