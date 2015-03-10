package org.fugazi.ql.type_checker.issue;

import org.fugazi.ql.ast.AbstractASTQLNode;

public class ASTNodeIssue {

    private final ASTNodeIssueType errorType;
    private final AbstractASTQLNode node;
    private final String message;

    public ASTNodeIssue(ASTNodeIssueType _errorType, AbstractASTQLNode _node, String _message) {
        this.errorType = _errorType;
        this.node = _node;
        this.message = _message;
    }

    public ASTNodeIssueType getErrorType() {
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
