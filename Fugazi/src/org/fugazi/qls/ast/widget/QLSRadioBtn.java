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

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSRadioBtn extends AbstractQLSWidget {

    private final String yesLabel;
    private final String noLabel;

    private JPanel component;
    private JLabel componentLabel;
    private ButtonGroup radioButtonGroup;
    private JRadioButton yesBtn;
    private JRadioButton noBtn;

    public QLSRadioBtn(String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.buildWidget("", _yes, _no);
    }

    public QLSRadioBtn(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.label = _label;
        this.buildWidget(_label, _yes, _no);
    }

    private void buildWidget(String _label, String _yes, String _no) {
        this.component = new JPanel();
        this.componentLabel = new JLabel(_label);

        this.yesBtn = new JRadioButton(_yes);
        this.noBtn = new JRadioButton(_no);
        this.radioButtonGroup = new ButtonGroup();
        
        radioButtonGroup.add(yesBtn);
        radioButtonGroup.add(noBtn);
        component.add(yesBtn);
        component.add(noBtn);
        component.add(componentLabel);
    }

    public String getYesLabel() {
        return yesLabel;
    }

    public String getNoLabel() {
        return noLabel;
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
    public BoolValue getWidgetValue() {
        return new BoolValue(false);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        // todo
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitRadioBtn(this);
    }
}
