package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

public abstract class Widget extends AbstractASTQLSNode {

    private String label;
    private Style style;

    public Widget(int _lineNum) {
        super(_lineNum);
        this.label = "";
    }

    public Widget() {
        this.label = "";
    }

    public void setLabel(String _label) {
        this.label = _label;
    }

    public abstract void applyStyle(Style _style);

    public boolean isNull() {
        return false;
    }

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);
}
