package org.fugazi.ql.ast;

public abstract class AbstractASTNode {

    protected final int lineNumber;

    public static final int DUMMY_LINE_NUMBER = -1;

    public AbstractASTNode() {
        // this is used for temporary objects
        this.lineNumber = DUMMY_LINE_NUMBER;
    }

    public AbstractASTNode(int _lineNum) {
        this.lineNumber = _lineNum;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
