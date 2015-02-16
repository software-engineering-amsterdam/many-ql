package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.question;

import org.uva.student.calinwouter.qlqls.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;

public class GuiIntegerQuestionStmtInterpreter extends GuiStringQuestionStmtInterpreter {

    @Override
    protected boolean update(String value) {
        try {
            formInterpreter.setField(node.getIdent().getText(), new TInteger(Integer.parseInt(value)));
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public GuiIntegerQuestionStmtInterpreter(FormInterpreter formInterpreter, AQuestionStmt node) {
        super(formInterpreter, node);
    }
}