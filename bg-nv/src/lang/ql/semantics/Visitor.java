package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;

/**
 * Created by bore on 13/02/15.
 */
public interface Visitor
{
    void visit(Form f);
    void visit(Question q);
    void visit(CalculatedQuestion q);
    void visit(IfCondition c);

    void visit(BoolExpr e);
    void visit(IntExpr e);
    void visit(DecExpr e);
    void visit(StrExpr e);
    void visit(Indent e);

    void visit(Neg e);
    void visit(Pos e);
    void visit(Not e);

    void visit(Add e);
    void visit(Sub e);
    void visit(Mul e);
    void visit(Div e);

    void visit(Gt e);
    void visit(Lt e);
    void visit(GtEqu e);
    void visit(LtEqu e);
    void visit(Equ e);
    void visit(NotEqu e);

    void visit(And e);
    void visit(Or e);
}
