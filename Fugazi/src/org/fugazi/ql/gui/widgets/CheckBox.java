package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBox implements IWidget {

    private JCheckBox component;

    public CheckBox(String _label) {
        component = new JCheckBox(_label);
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.component);
    }

    @Override
    public void supress(UIForm _canvas){
        _canvas.removeWidget(this.component);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {

        component.addItemListener(
            new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    _listener.stateChanged();
                }
            }
        );
    }

    @Override
    public BoolValue getWidgetValue() {
        return new BoolValue(this.component.isSelected());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        this.component.setSelected(value.getValue());
    }
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }
}
