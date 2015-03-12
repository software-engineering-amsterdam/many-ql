package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import java.util.ArrayList;
import java.util.List;

public class SpinBox extends Widget {

    public SpinBox(int _lineNum) {
        super(_lineNum);
    }

    public SpinBox() {
    }

    public SpinBox(int _lineNum, String _label) {
        super(_lineNum);
        this.label = _label;
    }

    public SpinBox(String _label) {
        this.label = _label;
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
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }


    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSpinBox(this);
    }
}