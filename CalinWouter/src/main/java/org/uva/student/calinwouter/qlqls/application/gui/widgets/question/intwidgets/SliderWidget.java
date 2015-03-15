package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Slider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class SliderWidget implements IWidget {
    private JSlider sliderWidget;

    @Override
    public Component getWidgetComponent() {
        return sliderWidget;
    }

    public SliderWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTable symbolTable, Slider slider) {
        this.sliderWidget = new JSlider(slider.getMin(), slider.getMax());

        sliderWidget.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                symbolTable.setVariable(question.getIdent(), new IntegerValue(sliderWidget.getValue()));
                qlIntepreter.interpret();
            }
        });
    }
}
