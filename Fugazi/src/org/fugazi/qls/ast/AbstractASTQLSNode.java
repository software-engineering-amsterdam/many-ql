package org.fugazi.qls.ast;

import org.fugazi.ql.ast.AbstractASTQLNode;

public abstract class AbstractASTQLSNode extends AbstractASTQLNode { // todo ASK about this inheritance.

    public AbstractASTQLSNode() {
        super();
    }

    public AbstractASTQLSNode(int _lineNum) {
        super(_lineNum);
    }
}
