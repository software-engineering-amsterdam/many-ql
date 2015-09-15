package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.logicalexpressions.LogicalExpression;
import nl.uva.bromance.QL.expressions.unary.Primitive;

public class If extends QLNode implements Evaluable{

    private LogicalExpression expr;

    public If(int ln, LogicalExpression expr) {
        super(ln);
        this.expr = expr;
    }

    @Override
    public Primitive evaluate() {
        return expr.evaluate();
    }
}
