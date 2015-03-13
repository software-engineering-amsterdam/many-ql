package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RadioBtn extends Widget {

    private final String yesLabel;
    private final String noLabel;

    private JPanel component;
    private JLabel componentLabel;

    public RadioBtn(int _lineNum, String _yes, String _no) {
        super(_lineNum);
        this.yesLabel = _yes;
        this.noLabel = _no;

        this.buildWidget("", _yes, _no);
    }

    public RadioBtn(String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.buildWidget("", _yes, _no);
    }

    public RadioBtn(int _lineNum, String _label, String _yes, String _no) {
        super(_lineNum);
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.label = _label;
        this.buildWidget(_label, _yes, _no);
    }

    public RadioBtn(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.label = _label;
        this.buildWidget(_label, _yes, _no);
    }

    private void buildWidget(String _label, String _yes, String _no) {
        this.component = new JPanel();
        this.componentLabel = new JLabel(_label);

        JRadioButton yesBtn = new JRadioButton(_yes);
        JRadioButton noBtn = new JRadioButton(_no);
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(yesBtn);
        radioButtonGroup.add(noBtn);
        component.add(yesBtn);
        component.add(noBtn);
        component.add(componentLabel);
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
