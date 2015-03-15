package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.*;

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

    public CheckboxWidget(final Question question, final QLIntepreter qlIntepreter, final SymbolTable symbolTable) {
        this.checkbox = new JCheckBox();

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                symbolTable.setVariable(question.getIdent(), new BoolValue(checkbox.isSelected()));
                qlIntepreter.interpret();
            }
        });
    }

    public CheckboxWidget(final QuestionField questionField, final QLIntepreter qlIntepreter, final SymbolTable symbolTable) {
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