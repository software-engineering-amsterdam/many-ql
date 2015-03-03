package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Combo;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboWidget implements IWidget {
    private JComboBox yesNoComboBox;

    @Override
    public Component getWidget() {
        return yesNoComboBox;
    }

    public ComboWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter, Combo combo) {
        yesNoComboBox = new JComboBox(new String[] {combo.getYesLbl(), combo.getNoLbl()});
        yesNoComboBox.setSelectedIndex(-1);

        yesNoComboBox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (yesNoComboBox.getSelectedIndex() == 0) {
                    System.out.println("true");
                    headlessFormInterpreter.setField(question.getFieldName(), new BoolValue(true));
                    headlessFormInterpreter.interpret();
                    return;
                }
                System.out.println("false");
                headlessFormInterpreter.setField(question.getFieldName(), new BoolValue(false));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
