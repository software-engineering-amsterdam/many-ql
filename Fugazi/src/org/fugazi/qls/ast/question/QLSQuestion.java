package org.fugazi.qls.ast.question;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

public class QLSQuestion extends AbstractASTNode {
    private final String identifier;
    private AbstractQLSWidget widget;

    public QLSQuestion(String _identifier, AbstractQLSWidget _widget) {
        this.identifier = _identifier;
        this.widget = _widget;
    }

    public String getIdName() {
        return this.identifier;
    }

    @Override
    public String toString() {
        return this.identifier + " " + "('" + this.widget.toString() + "')";
    }

    public void setWidget(AbstractQLSWidget _widget) {
        this.widget = _widget;
    }

    public AbstractQLSWidget getWidget() {
        return this.widget;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitQuestion(this);
    }
}