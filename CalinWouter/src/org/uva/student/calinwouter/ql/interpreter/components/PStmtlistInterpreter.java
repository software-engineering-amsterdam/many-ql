package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class PStmtlistInterpreter implements InterpreterInterface<PStmtlist> {
    private Environment environment;

    public void interpStatement(Node stmt) {
        new PStmtInterpreter().interprete(environment, (PStmt) stmt);
    }

    private void interpNextStatement(Node stmtlist) {
        if (stmtlist instanceof ASingleStmtlist) {
            interpStatement(((ASingleStmtlist) stmtlist).getHead());
        } else if (stmtlist instanceof AMultiStmtlist) {
            interpNextStatement(((AMultiStmtlist) stmtlist).getHead());
            interpStatement((((AMultiStmtlist) stmtlist).getTail()));
        }
    }

    @Override
    public void interprete(Environment environment, PStmtlist stmtlist) {
        this.environment = environment;
        interpNextStatement(stmtlist);
    }

}
