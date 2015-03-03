package org.fugazi.qls.ast.question;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.widget.Widget;

public class Question extends AbstractASTQLSNode { // todo Create A UIQuestion?

    private final String identifier;
    private final Widget widget;

    public Question(String _identifier, Widget _widget) {
        this.identifier = _identifier;
        this.widget = _widget;
    }
    
    public String getId() {
        return this.identifier;
    }
}