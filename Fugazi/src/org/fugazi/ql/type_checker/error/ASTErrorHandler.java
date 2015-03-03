package org.fugazi.ql.type_checker.error;

import org.fugazi.ql.ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class ASTErrorHandler {

    private final List<ASTNodeError> errors;
    private final List<ASTNodeError> warnings;

    public ASTErrorHandler() {
        this.errors   = new ArrayList<ASTNodeError>();
        this.warnings = new ArrayList<ASTNodeError>();
    }


    public List<ASTNodeError> getErrors() {
        return this.errors;
    }

    public List<ASTNodeError> getWarnings() {
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

    public void registerNewError(ASTNodeErrorType _type, AbstractASTNode _errorNode, String _message) {
        this.errors.add(new ASTNodeError(
                _type, _errorNode, _message
        ));
    }

    public void registerNewWarning(AbstractASTNode _errorNode, String _message) {
        this.warnings.add(new ASTNodeError(
                ASTNodeErrorType.WARNING.DUPLICATE_LABEL, _errorNode, _message
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
