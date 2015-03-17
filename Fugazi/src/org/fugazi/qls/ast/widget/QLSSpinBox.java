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
import org.fugazi.qls.ast.widget.widget_types.SpinBoxType;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;

public class QLSSpinBox extends AbstractQLSWidget {

    private static final int MIN = -1000;
    private static final int MAX = 1000;
    private static final int STEP = 1;

    private final JSpinner spinbox;

    public QLSSpinBox() {
        this("");
    }

    public QLSSpinBox(String _label) {
        this.label = _label;

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, MIN, MAX, STEP);
        this.spinbox = new JSpinner(spinnerModel);
        this.type = new SpinBoxType();
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

        this.spinbox.addChangeListener(
            new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    _listener.stateChanged();
                }
            }
        );
    }

    @Override
    public IntValue getWidgetValue() {
        return new IntValue((int) this.spinbox.getValue());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        this.spinbox.setValue(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.spinbox.setEnabled(false);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) this.spinbox.getEditor();
        editor.getTextField().setEnabled( true );
        editor.getTextField().setEditable( false );
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