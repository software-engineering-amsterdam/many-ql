package org.uva.student.calinwouter.qlqls.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class SliderWidget implements IWidget {
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private JSlider sliderWidget;

    public Component getWidgetComponent() {
        return sliderWidget;
    }

    public void resetValue() {
        sliderWidget.setValue(0);
    }

    private ChangeListener createChangeListener() {
        return new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new IntegerValue(sliderWidget.getValue()));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    public SliderWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper, int min, int max) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.sliderWidget = new JSlider(min, max);
        sliderWidget.addChangeListener(createChangeListener());

    }
}
