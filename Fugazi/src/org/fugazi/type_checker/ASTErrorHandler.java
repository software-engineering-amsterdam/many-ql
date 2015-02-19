package org.fugazi.type_checker;

import org.fugazi.ast.AbstractASTNode;
import org.fugazi.ast.expression.logical.And;

import java.util.ArrayList;

public class ASTErrorHandler {

    private ArrayList<ASTNodeError> errors;
    private ArrayList<ASTNodeError> warnings;

    public ASTErrorHandler() {
        this.errors   = new ArrayList<ASTNodeError>();
        this.warnings = new ArrayList<ASTNodeError>();
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public boolean hasWarnings() {
        return !this.warnings.isEmpty();
    }

    // TODO merge the two below into one method?
    public void registerNewError(AbstractASTNode _errorNode, String _message) {
        this.errors.add(new ASTNodeError(
                ASTNodeErrorType.ERROR, _errorNode, _message
        ));
    }

    public void registerNewWarning(AbstractASTNode _errorNode, String _message) {
        this.warnings.add(new ASTNodeError(
                ASTNodeErrorType.WARNING, _errorNode, _message
        ));
    }

    public void displayNodeError(ASTNodeError error) {
        System.out.print(error.getErrorType() + ": ");
        System.out.println(" at node " + error.getNode());

        System.out.println(error.getMessage()+ "\n");
    }

    public void displayErrors() {
        if (this.hasErrors()) {
            System.out.println("\n\n\nFollowing errors found in the form:\n");
        }
        for (ASTNodeError error : this.errors) {
            this.displayNodeError(error);
        }
    }

    public void displayWarnings() {
        if (this.hasWarnings()) {
            System.out.println("\n\n\nFollowing errors found in the form:\n");
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