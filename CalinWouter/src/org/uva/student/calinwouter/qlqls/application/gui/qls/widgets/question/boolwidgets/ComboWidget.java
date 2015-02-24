package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by calin on 2/24/15.
 */
public class ComboWidget implements IWidget {
    private JComboBox comboBox;

    @Override
    public Component getWidget() {
        return comboBox;
    }

    public ComboWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        final String[] comboBoxOptions = {"Yes", "No"};
        comboBox = new JComboBox(comboBoxOptions);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboBox.getSelectedItem().toString().equals("Yes")){
                    headlessFormInterpreter.setField(question.getFieldName(), new TBool(true));
                } else {
                    headlessFormInterpreter.setField(question.getFieldName(), new TBool(false));
                }
                headlessFormInterpreter.interpret();
            }
        });
    }
}
