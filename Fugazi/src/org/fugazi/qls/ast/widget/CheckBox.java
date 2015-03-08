package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

public class CheckBox extends Widget {

    public CheckBox(int _lineNum) {
        super(_lineNum);
    }

    public CheckBox() {
    }

    @Override
    public void applyStyle(Style _style) {
        // todo
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitCheckBox(this);
    }
}
