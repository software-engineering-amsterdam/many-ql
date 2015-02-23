package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.qls.model.Question;

import javax.swing.*;
import java.awt.*;

public class CheckboxWidget implements IWidget {
    private JCheckBox checkbox;

    @Override
    public Component getWidget() {
        return checkbox;
    }

    public CheckboxWidget(Question question) {
        this.checkbox = new JCheckBox();
    }
}
