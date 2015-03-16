package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSSpinBox extends AbstractQLSWidget {

    private final JSpinner spinbox;

    public QLSSpinBox() {
        this.spinbox = new JSpinner(new SpinnerNumberModel( 2,1,7,1 ));
    }

    public QLSSpinBox(String _label) {
        this.label = _label;
        this.spinbox = new JSpinner(new SpinnerNumberModel( 2,1,7,1 ));
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
        _canvas.addWidget(this.spinbox);
    }

    @Override
    public void supress(UIForm _canvas){
        _canvas.removeWidget(this.spinbox);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        //todo
    }

    @Override
    public IntValue getWidgetValue() {
        return new IntValue((int)spinbox.getValue());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        spinbox.setValue(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        spinbox.setEnabled(false);
    }
    
    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }


    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSpinBox(this);
    }
}