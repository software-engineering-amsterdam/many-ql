package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSDropdown extends AbstractQLSWidget<Boolean> {

    private final String yesLabel;
    private final String noLabel;

    public QLSDropdown(int _lineNum, String _yes, String _no) {
        super(_lineNum);
        this.yesLabel = _yes;
        this.noLabel = _no;
    }

    public QLSDropdown(String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
    }

    public QLSDropdown(int _lineNum, String _label, String _yes, String _no) {
        super(_lineNum);
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.label = _label;
    }

    public QLSDropdown(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
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
    }

    @Override
    public Boolean getValue() {
        // todo
        return false;
    }

    @Override
    public void setValue(Boolean _value) {
        // todo
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        // todo
    }


    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
