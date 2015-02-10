package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.ComputedValueModel;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.QuestionModel;

public class PStmtInterpreter implements InterpreterInterface<PStmt> {

    @Override
    public Object interprete(Environment e, PStmt node) throws InterpretationException {
        if (node instanceof AQuestionStmt) {
            AQuestionStmt questionStmt = (AQuestionStmt) node;

            e.getDisplayModels().add(
                    new QuestionModel(questionStmt.getIdent().getText(),
                    questionStmt.getStr().getText(), questionStmt.getType().toString()));
        } else if (node instanceof AValueStmt) {
            AValueStmt valueStmt = (AValueStmt) node;

            e.getDisplayModels().add(
                    new ComputedValueModel(valueStmt.getIdent().getText(),
                            valueStmt.getStr().getText(), valueStmt.getType().toString(), valueStmt.getExp()));
        } else if (node instanceof AIfelseStmt) {
            AIfelseStmt ifelseStmt = (AIfelseStmt) node;
            if ((Boolean) new PExpInterpreter().interprete(e, ifelseStmt.getExp())){
                new PStmtlistInterpreter().interprete(e, ifelseStmt.getIfstmts());
            } else {
                new PStmtlistInterpreter().interprete(e, ifelseStmt.getElsestmts());
            }
        } else if (node instanceof AIfStmt) {
            try {
                AIfStmt ifStmt = (AIfStmt) node;
                if((Boolean) new PExpInterpreter().interprete(e, ifStmt.getExp())) {
                    new PStmtlistInterpreter().interprete(e, ifStmt.getIfstmts());
                }
            } catch(Exception ee) {
                AIfStmt ifStmt = (AIfStmt) node;
                System.out.println("If Node: " + ifStmt.getExp().toString());
                System.out.println(e.getEnvVars().get("hasSoldHouse"));

                if (e.getEnvVars().get("hasSoldHouse") != null)
                    System.out.println(e.getEnvVars().get("hasSoldHouse").getClass());
                ee.printStackTrace();
                return false;
            }
        }
        return null;
    }
}
