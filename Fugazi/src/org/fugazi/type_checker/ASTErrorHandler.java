package org.fugazi.type_checker;

import java.util.ArrayList;

public class ASTErrorHandler {

    private ArrayList<ASTNodeError> errors;
    private ArrayList<ASTNodeError> warnings;

    public ASTErrorHandler() {
        this.errors   = new ArrayList<ASTNodeError>();
        this.warnings = new ArrayList<ASTNodeError>();
    }

    // TODO should this be an 'isCorrect' method? what is correct?
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    // TODO merge the two below into one method?
    public void registerNewError(ASTNodeError _error) {
        this.errors.add(_error);
    }

    public void registerNewWarning(ASTNodeError _warning) {
        this.warnings.add(_warning);
    }

    public void displayNodeError(ASTNodeError error) {
        System.out.println("Error found in your AST tree:");

        System.out.print(error.getErrorType() + ": ");
        System.out.println(" at node " + error.getNode());

        System.out.println(error.getMessage());
    }

    public void displayErrors() {
        for (ASTNodeError error : this.errors) {
            this.displayNodeError(error);
        }
    }

    public void displayWarnings() {
        for (ASTNodeError warning : this.warnings) {
            this.displayNodeError(warning);
        }
    }

    public void displayWarningsAndErrors() {
        this.displayWarnings();
        this.displayErrors();
    }
}
