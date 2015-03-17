package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
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

    @Override
    public void resetValue() {
        sliderWidget.setValue(0);
    }

    public SliderWidget(final String questionIdentifier, final QLInterpreter qlInterpreter, final StateWrapper stateWrapper, Slider slider) {
        this.sliderWidget = new JSlider(slider.getMin(), slider.getMax());

        sliderWidget.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new IntegerValue(sliderWidget.getValue()));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        });

    }
}
