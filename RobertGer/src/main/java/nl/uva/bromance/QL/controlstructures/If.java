package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.logicalexpressions.LogicalExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class If extends QLNode implements Evaluable {

    private Expression expr;

    public If(int ln, Expression expr) {
        super(ln);
        this.expr = expr;
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s) {
        return (BooleanPrimitive) expr.evaluate(s);
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        Primitive type = expr.typeCheck(s, exceptions);
        BooleanPrimitive bool = BooleanPrimitive.defaultValue(type.getLineNumber());
        try {
            bool = (BooleanPrimitive) type;
        } catch (ClassCastException cce) {
            exceptions.add(new TypeCheckingError("If's can only contain BooleanPrimitive's see line: "+ getLineNumber()));
        }
        return type;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
        visitor.exit(this);
    }
}
