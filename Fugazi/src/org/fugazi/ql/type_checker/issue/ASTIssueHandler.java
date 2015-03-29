package org.fugazi.ql.type_checker.issue;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.type_checker.issue.warning.DuplicateLabelWarning;

import java.util.ArrayList;
import java.util.List;

public class ASTIssueHandler {

    private final List<ASTNodeIssue> errors;
    private final List<ASTNodeIssue> warnings;

    public ASTIssueHandler() {
        this.errors   = new ArrayList<ASTNodeIssue>();
        this.warnings = new ArrayList<ASTNodeIssue>();
    }


    public List<ASTNodeIssue> getErrors() {
        return this.errors;
    }

    public List<ASTNodeIssue> getWarnings() {
        return this.warnings;
    }

    /**
     * =======================
     * Error checks
     * =======================
     */

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public boolean hasWarnings() {
        return !this.warnings.isEmpty();
    }

    /**
     * =======================
     * Errors registration
     * =======================
     */

    public void registerNewError(ASTNodeIssueType _type, AbstractASTNode _errorNode, String _message) {
        this.errors.add(new ASTNodeIssue(
                _type, _errorNode, _message
        ));
    }

    public void registerNewWarning(AbstractASTNode _errorNode, String _message) {
        this.warnings.add(new ASTNodeIssue(
                new DuplicateLabelWarning(), _errorNode, _message
        ));
    }

    /**
     * =======================
     * Errors clearing
     * =======================
     */
    // necessary for reusing
    public void clearErrorsAndWarnings() {
        this.warnings.clear();
        this.errors.clear();
    }
}
