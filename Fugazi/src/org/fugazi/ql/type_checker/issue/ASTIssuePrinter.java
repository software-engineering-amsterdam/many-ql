package org.fugazi.ql.type_checker.issue;

import java.util.List;

public class ASTIssuePrinter {

    private List<ASTNodeIssue> errors;
    private List<ASTNodeIssue> warnings;

    public ASTIssuePrinter(List<ASTNodeIssue> _errors, List<ASTNodeIssue> _warnings) {
        this.errors   = _errors;
        this.warnings = _warnings;
    }


    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public boolean hasWarnings() {
        return !this.warnings.isEmpty();
    }


    /**
     * =======================
     * Errors display
     * =======================
     */

    public void displayNodeError(ASTNodeIssue error) {
        System.err.print(error.getErrorType() + ": ");
        System.err.print(" at line " + error.getLine());
        System.err.println(", expression: " + error.getNode().toString());

        System.err.println(error.getMessage()+ "\n");
    }

    public void displayErrors() {
        if (this.hasErrors()) {
            System.err.println("\n\n\nFollowing errors found in the form:\n");
        }
        for (ASTNodeIssue error : this.errors) {
            this.displayNodeError(error);
        }
    }

    public void displayWarnings() {
        if (this.hasWarnings()) {
            System.err.println("\n\n\nFollowing warnings found in the form:\n");
        }
        for (ASTNodeIssue warning : this.warnings) {
            this.displayNodeError(warning);
        }
    }

    public void displayWarningsAndErrors() {
        this.displayWarnings();
        this.displayErrors();
    }

}
