package org.fugazi.ql.type_checker.issue;

import java.util.List;

public class ASTIssuePrinter {

    public ASTIssuePrinter() {
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

    public void displayErrors(List<ASTNodeIssue> errors) {
        if (!errors.isEmpty()) {
            System.err.println("\n\n\nFollowing errors found in the form:\n");
        }
        for (ASTNodeIssue error : errors) {
            this.displayNodeError(error);
        }
    }

    public void displayWarnings(List<ASTNodeIssue> warnings) {
        if (!warnings.isEmpty()) {
            System.err.println("\n\n\nFollowing warnings found in the form:\n");
        }
        for (ASTNodeIssue warning : warnings) {
            this.displayNodeError(warning);
        }
    }

    public void displayWarningsAndErrors(List<ASTNodeIssue> errors, List<ASTNodeIssue> warnings) {
        this.displayWarnings(errors);
        this.displayErrors(warnings);
    }
}
