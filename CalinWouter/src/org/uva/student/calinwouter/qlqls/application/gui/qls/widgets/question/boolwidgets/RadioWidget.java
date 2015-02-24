package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import java.awt.*;

public class RadioWidget implements IWidget {
    private JCheckBox radio;

    @Override
    public Component getWidget() {
        return radio;
    }

    public RadioWidget(Question question, HeadlessFormInterpreter headlessFormInterpreter) {

        // TODO change to radio.
        this.radio = new JCheckBox();
    }
}
