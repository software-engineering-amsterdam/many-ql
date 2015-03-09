package org.fugazi.ql.type_checker.issue;

import org.fugazi.ql.ast.AbstractASTNode;

public class ASTNodeIssue {

    private final ASTNodeIssueType errorType;
    private final AbstractASTNode node;
    private final String message;

    public ASTNodeIssue(ASTNodeIssueType _errorType, AbstractASTNode _node, String _message) {
        this.errorType = _errorType;
        this.node = _node;
        this.message = _message;
    }

    public ASTNodeIssueType getErrorType() {
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
