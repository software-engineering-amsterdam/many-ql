package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.ql.generated.node.AValueStmt;
import org.uva.student.calinwouter.ql.generated.node.PStmt;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.io.Console;
import java.util.Scanner;

public class PStmtInterpreter implements InterpreterInterface<PStmt> {

    @Override
    public void interprete(Environment e, PStmt node) {
        if (node instanceof AQuestionStmt) {
            System.out.println(((AQuestionStmt) node).getStr());
            // Scanner sc = new Scanner(System.in);
            String in = ""; // ..
            e.getEnvVars().put(((AQuestionStmt) node).getIdent().getText(), in);
        } else if (node instanceof AValueStmt) {

        }
    }
}
