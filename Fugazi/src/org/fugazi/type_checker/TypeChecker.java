package org.fugazi.type_checker;

import org.fugazi.ast.form.Form;
import org.fugazi.type_checker.error.ASTNodeError;
import org.fugazi.type_checker.visitor.TypeCheckerVisitor;

import java.util.List;


public class TypeChecker {
    private final TypeCheckerVisitor visitor;

    public TypeChecker() {
        this.visitor = new TypeCheckerVisitor();
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm(Form form) {
        form.accept(this.visitor);
        return this.visitor.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return this.visitor.isFormCorrect();
    }

    public List<ASTNodeError> getErrors() {
        return this.visitor.getErrors();
    }

    public List<ASTNodeError> getWarnings() {
        return this.visitor.getWarnings();
    }
}
