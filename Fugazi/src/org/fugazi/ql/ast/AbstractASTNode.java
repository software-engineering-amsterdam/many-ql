package org.fugazi.ql.ast;

public abstract class AbstractASTNode {

    private int lineNumber;

    public static final int DUMMY_LINE_NUMBER = -1;

    public AbstractASTNode() {
        // this is used for temporary objects
        this.lineNumber = DUMMY_LINE_NUMBER;
    }
    
    public void setLineNumber(int _lineNum) {
        this.lineNumber = _lineNum;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
