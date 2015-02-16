package lang.ql.ast.visitor;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;

/**
 * Created by bore on 13/02/15.
 */
public interface Visitor
{
    void visit(Form n);
    void visit(Question n);
    void visit(CalculatedQuestion n);
    void visit(IfCondition n);
    void visit(Expression n);

    void visit(BooleanExpression n);
    void visit(IntegerExpression n);
    void visit(DecimalExpression n);
    void visit(StringExpression n);

    void visit(AdditionExpression n);
    void visit(SubtractionExpression n);
    void visit(GreaterThanExpression n);
    void visit(UnaryMinusExpression n);
    void visit(UnaryPlusExpression n);

    void visit(VariableExpression n);
    // TODO: Add all expressions
}
