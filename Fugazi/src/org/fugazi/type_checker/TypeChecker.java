package org.fugazi.type_checker;

import org.fugazi.ast.form.Form;
import org.fugazi.type_checker.visitor.TypeCheckerVisitor;


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

    public void displayFormWarningsAndErrors() {
        this.visitor.displayFormWarningsAndErrors();
        return;
    }
}
