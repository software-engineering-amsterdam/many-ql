package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.logicalexpressions.LogicalExpression;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

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

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions){
        return expr.typeCheck(s,exceptions);
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
