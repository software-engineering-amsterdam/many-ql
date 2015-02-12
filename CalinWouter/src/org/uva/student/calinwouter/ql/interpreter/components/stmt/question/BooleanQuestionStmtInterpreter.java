package org.uva.student.calinwouter.ql.interpreter.components.stmt.question;

import org.uva.student.calinwouter.ql.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.components.types.TypeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BooleanQuestionStmtInterpreter {
    private final FormInterpreter formInterpreter;
    private final AQuestionStmt node;

    public Component interprete() {
        final JCheckBox cb = new JCheckBox();
        TypeModel<?> value = formInterpreter.getField(node.getIdent().getText());
        if (value instanceof TBool)
            cb.setSelected(((TBool) value).getValue());

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                formInterpreter.setField(node.getIdent().getText(), new TBool(cb.isSelected()));
            }
        });
        return cb;
    }

    public BooleanQuestionStmtInterpreter(FormInterpreter formInterpreter, AQuestionStmt node) {
        this.formInterpreter = formInterpreter;
        this.node = node;
    }
}
