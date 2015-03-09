package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import java.util.List;

public abstract class Widget extends AbstractASTNode {

    private String label;
    private Style style;

    public Widget(int _lineNum) {
        super(_lineNum);
        this.label = "";
    }

    public Widget() {
        this.label = "";
    }

    public abstract void applyStyle(Style _style);

    public abstract List<Type> getSupportedQuestionTypes();

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);

    public void setLabel(String _label) {
        this.label = _label;
    }

    public boolean isNull() {
        return false;
    }
}
