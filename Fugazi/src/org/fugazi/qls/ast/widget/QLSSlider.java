package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.SliderType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSSlider extends AbstractQLSWidget {

    private final JSlider slider;

    public QLSSlider() {
        this("");
    }

    public QLSSlider(String _label) {
        this.label = _label;
        this.slider = new JSlider();
        this.type = new SliderType();
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
        _canvas.addWidget(this.slider);
    }

    @Override
    public void supress(UIForm _canvas){
        _canvas.removeWidget(this.slider);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        //todo
    }

    @Override
    public IntValue getWidgetValue() {
        //todo
        return new IntValue(0);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        // todo
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        // todo
    }
    
    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new IntType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSlider(this);
    }
}