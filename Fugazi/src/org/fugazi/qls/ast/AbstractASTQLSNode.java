package org.fugazi.qls.ast;

public abstract class AbstractASTQLSNode {

    protected final int lineNumber;

    public static final int DUMMY_LINE_NUMBER = -1;

    public AbstractASTQLSNode() {
        // this is used for temporary objects
        this.lineNumber = DUMMY_LINE_NUMBER;
    }

    public AbstractASTQLSNode(int _lineNum) {
        this.lineNumber = _lineNum;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
