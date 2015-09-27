package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;

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
    public Primitive typeCheck(SymbolTable s, List<QLError> exceptions) {
        Primitive type = expr.typeCheck(s, exceptions);
        // If type is null the expression typechecker couldn't find a variable
        if (type != null) {
            BooleanPrimitive bool = BooleanPrimitive.defaultValue(type.getLineNumber());
            try {
                bool = (BooleanPrimitive) type;
            } catch (ClassCastException cce) {
                exceptions.add(new TypeCheckingError("If's can only contain BooleanPrimitive's see line: " + getLineNumber(), TypeCheckingError.Type.ERROR));
            }
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

    public void visitExpression(QLNodeVisitorInterface visitor){
        this.expr.accept(visitor);
    }
}
