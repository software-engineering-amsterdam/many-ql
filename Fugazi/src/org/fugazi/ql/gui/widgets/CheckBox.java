package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBox implements IWidget {

    private JCheckBox checkBox;

    public CheckBox(String _label) {
        this.checkBox = new JCheckBox(_label);
        this.checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.checkBox);
    }

    @Override
    public void suppress(UIForm _canvas){
        _canvas.removeWidget(this.checkBox);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {

        checkBox.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        _listener.stateChanged();
                    }
                }
        );
    }

    @Override
    public BoolValue getWidgetValue() {
        return new BoolValue(this.checkBox.isSelected());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        this.checkBox.setSelected(value.getValue());
    }
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.checkBox.setEnabled(false);
    }
}
