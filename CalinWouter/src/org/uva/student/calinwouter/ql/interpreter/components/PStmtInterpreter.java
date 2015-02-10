package org.uva.student.calinwouter.ql.interpreter.components;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.QuestionModel;

import java.io.Console;
import java.util.LinkedList;
import java.util.Scanner;

public class PStmtInterpreter implements InterpreterInterface<PStmt> {

    @Override
    public Object interprete(Environment e, PStmt node) {
        if (node instanceof AQuestionStmt) {
            AQuestionStmt questionStmt = (AQuestionStmt) node;

            e.getQuestionModels().add(
                    new QuestionModel(questionStmt.getIdent().getText(),
                    questionStmt.getStr().getText(), questionStmt.getType().toString()));
        } else if (node instanceof AValueStmt) {
            AValueStmt valueStmt = (AValueStmt) node;
            System.out.println(valueStmt.getStr() + new PExpInterpreter().interprete(e, valueStmt.getExp()).toString());
        } else if (node instanceof AIfelseStmt) {
            AIfelseStmt ifelseStmt = (AIfelseStmt) node;
            if ((Boolean) new PExpInterpreter().interprete(e, ifelseStmt.getExp())){
                return new PStmtlistInterpreter().interprete(e, ifelseStmt.getIfstmts());
            } else {
                return new PStmtlistInterpreter().interprete(e, ifelseStmt.getElsestmts());
            }
        } else if (node instanceof AIfStmt) {
            AIfStmt ifStmt = (AIfStmt) node;
            if((Boolean) new PExpInterpreter().interprete(e, ifStmt.getExp())) {
                new PStmtlistInterpreter().interprete(e, ifStmt.getIfstmts());
            }
        }
        return null;
    }
}
