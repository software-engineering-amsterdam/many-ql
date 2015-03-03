package org.fugazi.ql.ast;

public abstract class AbstractASTQLNode {

    protected final int lineNumber;

    public static final int DUMMY_LINE_NUMBER = -1;

    public AbstractASTQLNode() {
        // this is used for temporary objects
        this.lineNumber = DUMMY_LINE_NUMBER;
    }

    public AbstractASTQLNode(int _lineNum) {
        this.lineNumber = _lineNum;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
