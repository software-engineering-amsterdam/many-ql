package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.expressions.binary.logicalexpressions.LogicalExpression;

public class ElseIf extends If {
    public ElseIf(int ln, LogicalExpression expr) {
        super(ln, expr);
    }
}
