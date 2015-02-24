package org.fugazi.type_checker.error;

import java.util.List;

public class ASTErrorPrinter {

    private List<ASTNodeError> errors;
    private List<ASTNodeError> warnings;

    public ASTErrorPrinter(List<ASTNodeError> _errors, List<ASTNodeError> _warnings) {
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

    public void displayNodeError(ASTNodeError error) {
        System.err.print(error.getErrorType() + ": ");
        System.err.print(" at line " + error.getLine());
        System.err.println(", expression: " + error.getNode().toString());

        System.err.println(error.getMessage()+ "\n");
    }

    public void displayErrors() {
        if (this.hasErrors()) {
            System.err.println("\n\n\nFollowing errors found in the form:\n");
        }
        for (ASTNodeError error : this.errors) {
            this.displayNodeError(error);
        }
    }

    public void displayWarnings() {
        if (this.hasWarnings()) {
            System.err.println("\n\n\nFollowing warnings found in the form:\n");
        }
        for (ASTNodeError warning : this.warnings) {
            this.displayNodeError(warning);
        }
    }

    public void displayWarningsAndErrors() {
        this.displayWarnings();
        this.displayErrors();
    }

}
