package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import java.awt.*;

public class TextboxWidget implements IWidget {
    private Component widget;

    // TODO add intbox specific implementation.
    public TextboxWidget(Question question, HeadlessFormInterpreter headlessFormInterpreter) {
        this.widget = new JTextField(20);
    }

    @Override
    public Component getWidget() {
        return widget;
    }
}
