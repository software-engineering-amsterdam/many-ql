package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class SliderWidget implements IWidget {
    private JSlider slider;

    @Override
    public Component getWidget() {
        return slider;
    }

    public SliderWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        slider = new JSlider();

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                headlessFormInterpreter.setField(question.getFieldName(), new TInteger(slider.getValue()));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
