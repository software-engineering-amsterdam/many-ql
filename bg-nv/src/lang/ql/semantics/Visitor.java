package lang.ql.semantics;

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

    void visit(BooleanExpr n);
    void visit(IntegerExpr n);
    void visit(DecimalExpr n);
    void visit(StringExpr n);

    void visit(Add n);
    void visit(Sub n);
    void visit(Gt n);
    void visit(Neg n);
    void visit(Pos n);

    void visit(Variable n);
    // TODO: Add all expressions
}
