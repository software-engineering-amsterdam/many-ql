package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBox extends Widget {

    private JCheckBox component;

    public CheckBox(int _lineNum) {
        super(_lineNum);
        this.component = new JCheckBox();
    }

    public CheckBox() {
        this.component = new JCheckBox();
    }

    public CheckBox(int _lineNum, String _label) {
        super(_lineNum);
        this.label = _label;
        this.component = new JCheckBox(label);
    }

    public CheckBox(String _label) {
        this.label = _label;
        this.component = new JCheckBox(label);
    }

    @Override
    public void setLabel(String _label) {
        this.label = _label;
        this.component.setText(label);
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
        return _visitor.visitCheckBox(this);
    }
}
