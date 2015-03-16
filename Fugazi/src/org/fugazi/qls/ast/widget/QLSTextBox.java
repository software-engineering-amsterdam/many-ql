package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.Width;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSTextBox extends AbstractQLSWidget {

    public final static int DEFAULT_WIDTH = 7;

    private JPanel component;
    private JTextField componentValue;
    private JLabel componentLabel;

    public QLSTextBox() {
        this.buildWidget("");
    }

    public QLSTextBox(String _label) {
        this.label = _label;
        this.buildWidget(_label);
    }

    private void buildWidget(String _label) {
        this.component = new JPanel();
        this.componentValue = new JTextField();
        this.componentLabel = new JLabel(_label);
        this.component.add(componentValue);
        this.component.add(componentLabel);
    }

    @Override
    public void setLabel(String _label) {
        this.label = _label;
        this.componentLabel.setText(label);
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;

        // inherit properties that are not set in the given style from default.
        this.style.inheriteFromStyle(this.getDefaultStyle());

        // todo
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
        //todo
    }

    @Override
    public StringValue getWidgetValue() {
        return new StringValue(this.componentValue.getText());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        StringValue value = (StringValue) _value;
        this.componentValue.setText(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.componentValue.setEnabled(false);
    }
    
    @Override
    public Width getDefaultWidth() {
        return new Width(DEFAULT_WIDTH);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitTextBox(this);
    }
}