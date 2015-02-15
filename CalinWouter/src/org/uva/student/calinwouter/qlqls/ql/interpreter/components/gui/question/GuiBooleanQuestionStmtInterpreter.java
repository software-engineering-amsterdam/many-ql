package org.uva.student.calinwouter.qlqls.ql.interpreter.components.gui.question;

import org.uva.student.calinwouter.qlqls.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.types.TBool;
import org.uva.student.calinwouter.qlqls.ql.interpreter.types.TypeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GuiBooleanQuestionStmtInterpreter {
    private final FormInterpreter formInterpreter;
    private final AQuestionStmt node;

    public Component interpret() {
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

    public GuiBooleanQuestionStmtInterpreter(FormInterpreter formInterpreter, AQuestionStmt node) {
        this.formInterpreter = formInterpreter;
        this.node = node;
    }
}
