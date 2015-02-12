package org.uva.student.calinwouter.ql.interpreter.components.stmt.question;

import org.uva.student.calinwouter.ql.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.types.TInteger;

public class IntegerQuestionStmtInterpreter extends StringQuestionStmtInterpreter {

    @Override
    protected boolean update(String value) {
        try {
            formInterpreter.setField(node.getIdent().getText(), new TInteger(Integer.parseInt(value)));
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public IntegerQuestionStmtInterpreter(FormInterpreter formInterpreter, AQuestionStmt node) {
        super(formInterpreter, node);
    }
}