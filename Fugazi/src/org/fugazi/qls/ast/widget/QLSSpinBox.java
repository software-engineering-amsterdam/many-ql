package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSSpinBox extends AbstractQLSWidget<String> {

    public QLSSpinBox(int _lineNum) {
        super(_lineNum);
    }

    public QLSSpinBox() {
    }

    public QLSSpinBox(int _lineNum, String _label) {
        super(_lineNum);
        this.label = _label;
    }

    public QLSSpinBox(String _label) {
        this.label = _label;
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;

        // inherit properties that are not set in the given style from default.
        this.style.inheriteFromStyle(this.getDefaultStyle());

        // todo
    }

    @Override
    public JComponent getJComponent() {
        // todo
        return null;
    }

    @Override
    public void addEventListener(EventListener _listener) {
        // todo
        //this.componentValue.getDocument().addDocumentListener((DocumentListener) _listener);
    }

    @Override
    public String getValue() {
        // todo
        return "";
    }

    @Override
    public void setValue(String _value) {
        // todo
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        // todo
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