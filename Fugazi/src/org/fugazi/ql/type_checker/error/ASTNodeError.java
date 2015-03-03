package org.fugazi.ql.type_checker.error;

import org.fugazi.ql.ast.AbstractASTQLNode;

public class ASTNodeError {

    private final ASTNodeErrorType errorType;
    private final AbstractASTQLNode node;
    private final String message;

    public ASTNodeError(ASTNodeErrorType _errorType, AbstractASTQLNode _node, String _message) {
        this.errorType = _errorType;
        this.node = _node;
        this.message = _message;
    }

    public ASTNodeErrorType getErrorType() {
        return this.errorType;
    }

    public AbstractASTQLNode getNode() {
        return this.node;
    }

    public int getLine() {
        return this.node.getLineNumber();
    }

    public String getMessage() {
        return this.message;
    }
}
