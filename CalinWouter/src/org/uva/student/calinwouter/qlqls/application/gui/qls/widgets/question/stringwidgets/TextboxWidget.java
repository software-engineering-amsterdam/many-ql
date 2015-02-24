package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextboxWidget implements IWidget {
    protected JTextField widget;

    // TODO add implementations details
    public TextboxWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        this.widget = new JTextField(20);
    }

    @Override
    public Component getWidget() {
        return widget;
    }
}
