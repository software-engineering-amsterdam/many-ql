package org.uva.student.calinwouter.ql.interpreter.components;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.io.Console;
import java.util.Scanner;

public class PStmtInterpreter implements InterpreterInterface<PStmt> {

    @Override
    public void interprete(Environment e, PStmt node) {
        if (node instanceof AQuestionStmt) {
            System.out.println(((AQuestionStmt) node).getStr());
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            e.getEnvVars().put(((AQuestionStmt) node).getIdent().getText(), in);
        } else if (node instanceof AValueStmt) {
            PExpIntepreter expI = new PExpIntepreter();
            expI.interprete(e, ((AValueStmt) node).getExp());
            System.out.println(((AValueStmt) node).getStr() + expI.getExpValue().toString());
        } else if (node instanceof AIfelseStmt) {
            PExpIntepreter expI =  new PExpIntepreter();
            expI.interprete(e, ((AIfelseStmt) node).getExp());
            if((Boolean) expI.getExpValue()){
                new PStmtlistInterpreter().interprete(e, ((AIfelseStmt) node).getIfstmts());
            } else {
                new PStmtlistInterpreter().interprete(e, ((AIfelseStmt) node).getElsestmts());
            }
        } else if (node instanceof AIfStmt) {
            PExpIntepreter expI = new PExpIntepreter();
            expI.interprete(e, ((AIfStmt) node).getExp());
            if(expI.getExpValue() instanceof Boolean && ((Boolean) expI.getExpValue())){
                new PStmtlistInterpreter().interprete(e, ((AIfStmt) node).getIfstmts());
            } else if (expI.getExpValue() instanceof String && Boolean.parseBoolean(expI.getExpValue().toString())){
                new PStmtlistInterpreter().interprete(e, ((AIfStmt) node).getIfstmts());
            }
        }
    }
}
