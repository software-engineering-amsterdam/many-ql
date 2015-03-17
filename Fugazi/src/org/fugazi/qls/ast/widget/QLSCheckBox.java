package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.CheckBoxType;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class QLSCheckBox extends AbstractQLSWidget {

    private JCheckBox checkBox;

    public QLSCheckBox() {
        this("");
    }

    public QLSCheckBox(String _label) {
        this.checkBox = new JCheckBox(_label);
        this.checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
        this.type = new CheckBoxType();
    }

    @Override
    public void setLabel(String _label) {
        this.checkBox.setText(_label);
    }

    @Override
    public void applyStyle(Style _style) {
        Style style = _style;

        // inherit properties that are not set in the given style from default.
        style.inheriteFromStyle(this.getDefaultStyle());

        // todo
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.checkBox);
    }

    @Override
    public void supress(UIForm _canvas){
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

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitCheckBox(this);
    }
}
