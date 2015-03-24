package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.SliderType;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSSlider extends AbstractQLSWidget {

    private static final int MIN = -1000;
    private static final int MAX = 1000;
    private static final int STEP = 1;

    private final JLabel componentLabel;
    private final JPanel panel;
    private final JSlider slider;
    private JLabel valueLabel;

    public QLSSlider() {
        this("");
    }

    public QLSSlider(String _label) {

        this.panel = new JPanel();
        this.componentLabel = new JLabel(_label);
        this.valueLabel = new JLabel("0");
        this.slider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, STEP);

        this.panel.add(this.componentLabel);
        this.panel.add(this.slider);
        this.panel.add(this.valueLabel);

        this.type = new SliderType();
    }

    @Override
    public void applyStyle(Style _style) {
        // inherit properties that are not set in the given style from default.
        _style.inheriteFromStyle(this.getDefaultStyle());

        Font font = new Font(
                _style.getFont(this.getDefaultFont().getValue()), 0,
                _style.getFontSize(this.getDefaultFontSize().getValue())
        );
        this.componentLabel.setFont(font);

        Color color = _style.getColor(this.getDefaultColor().getValue());
        this.componentLabel.setForeground(color);

        this.slider.setPreferredSize(
                new Dimension(
                        this.getDefaultWidth().getValue(), 
                        (int) this.slider.getPreferredSize().getHeight()
                )
        );
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.panel);
    }

    @Override
    public void suppress(UIForm _canvas){
        _canvas.removeWidget(this.panel);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {

        this.slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int v = (int)source.getValue();
                valueLabel.setText(Integer.toString(v));
                _listener.stateChanged();
            }
        });
    }

    @Override
    public IntValue getWidgetValue() {
        return new IntValue(this.slider.getValue());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        this.slider.setValue(value.getValue());
        this.valueLabel.setText(Integer.toString(value.getValue()));
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.slider.setEnabled(_isReadonly);
    }
    
    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>(
                Arrays.asList(new IntType())
        );
        return supportedTypes;
    }

    @Override
    public void setLabel(String _label) {
        this.componentLabel.setText(_label);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSlider(this);
    }
}