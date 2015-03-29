package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.CheckBoxType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSCheckBox extends AbstractQLSWidget {

    private JCheckBox checkBox;

    public QLSCheckBox() {
        this("");
    }

    public QLSCheckBox(String _label) {
        this.componentLabel.setText(_label);
        this.checkBox = new JCheckBox(_label);
        this.checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
        this.component.add(this.checkBox);
        this.type = new CheckBoxType();
    }

    @Override
    public void setLabel(String _label) {
        this.checkBox.setText(_label);
    }

    @Override
    public void applyStyle(Style _style) {
        _style.inheriteFromStyle(this.getDefaultStyle());

        Font font = new Font(
            _style.getFont(this.getDefaultFont().getValue()), 0,
            _style.getFontSize(this.getDefaultFontSize().getValue())
        );
        this.checkBox.setFont(font);

        Color color = _style.getColor(this.getDefaultColor().getValue());
        this.checkBox.setForeground(color);
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
        List<Type> supportedTypes = new ArrayList<>(
            Arrays.asList(
                    new BoolType(),
                    new StringType()
            )
        );
        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitCheckBox(this);
    }
}
