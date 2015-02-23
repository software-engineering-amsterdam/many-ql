package org.fugazi.ast;

/*
 We decided it should be an abstract class rather than an interface.
 The rationale behind it is that we need it to have some additional fields,
 such as error line number.
 */
public abstract class AbstractASTNode {

    protected final int lineNumber;
    
    public AbstractASTNode(int _lineNum) {
        this.lineNumber = _lineNum;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
