package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxWidget implements IWidget {
    private JCheckBox checkbox;

    @Override
    public Component getWidgetComponent() {
        return checkbox;
    }

    public CheckboxWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
        this.checkbox = new JCheckBox();

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                symbolTable.setVariable(question.getIdent(), new BoolValue(checkbox.isSelected()));
                qlIntepreter.interpret();
            }
        });
    }

    public CheckboxWidget(final QuestionField questionField, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
        this.checkbox = new JCheckBox();

        checkbox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                symbolTable.setVariable(questionField.getVariable(), new BoolValue(checkbox.isSelected()));
                qlIntepreter.interpret();
            }
        });
    }
}
