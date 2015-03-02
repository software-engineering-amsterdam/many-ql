package org.fugazi.ql.type_checker.error;

import org.fugazi.ql.ast.AbstractASTNode;

public class ASTNodeError {

    private final ASTNodeErrorType errorType;
    private final AbstractASTNode node;
    private final String message;

    public ASTNodeError(ASTNodeErrorType _errorType, AbstractASTNode _node, String _message) {
        this.errorType = _errorType;
        this.node = _node;
        this.message = _message;
    }

    public ASTNodeErrorType getErrorType() {
        return this.errorType;
    }

    public AbstractASTNode getNode() {
        return this.node;
    }

    public int getLine() {
        return this.node.getLineNumber();
    }

    public String getMessage() {
        return this.message;
    }
}
