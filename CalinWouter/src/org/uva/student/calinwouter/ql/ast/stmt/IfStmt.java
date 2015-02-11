package org.uva.student.calinwouter.ql.ast.stmt;

import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class IfStmt extends Stmt {
    private Exp exp;
    private Stmt thenStmt, elseStmt;

    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        if (exp.interpret(environment).getValue().equals(Boolean.TRUE)) {
            return thenStmt.interpret(environment);
        }
        return elseStmt.interpret(environment);
    }

    public IfStmt(Exp exp, Stmt thenStmt, Stmt elseStmt) {
        this.exp = exp;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }
}
