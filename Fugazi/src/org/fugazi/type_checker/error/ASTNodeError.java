package org.fugazi.type_checker.error;

import org.fugazi.ast.AbstractASTNode;

enum ASTNodeErrorType {ERROR, WARNING};

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
