package org.fugazi.qls.ast.question;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.widget.Widget;

public class Question extends AbstractASTNode {
    private final String identifier;
    private final Widget widget;

    public Question(int _lineNum,String _identifier, Widget _widget) {
        super(_lineNum);
        this.identifier = _identifier;
        this.widget = _widget;
    }

    public Question(String _identifier, Widget _widget) {
        this.identifier = _identifier;
        this.widget = _widget;
    }

    public String getIdName() {
        return this.identifier;
    }

    @Override
    public String toString() {
        return this.identifier.toString() + " " + "('" + this.widget.toString() + "')";
    }

    public Widget getWidget() {
        return this.widget;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitQuestion(this);
    }
}