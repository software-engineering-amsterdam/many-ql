package org.fugazi.type_checker;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;

import java.util.ArrayList;

/*
// TODO type checker must detect

reference to undefined questions
duplicate question declarations with different types
conditions that are not of the type boolean
cyclic dependencies between questions
duplicate labels (warning)
 */

public class TypeChecker {

    // TODO ERROR HANDLER NEEDS TO BE CLEANED ON EACH CHECK
    // should it be final then?
    // or use clean method like now?
    private final ASTErrorHandler astErrorHandler;
    private final TypeCheckerVisitor visitor;

    public TypeChecker() {
        this.astErrorHandler = new ASTErrorHandler();
        this.visitor = new TypeCheckerVisitor();
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    // TODO should there be a separate isFormCorrect method?
    public boolean checkForm(Form form) {
        form.accept(this.visitor);
        return !this.astErrorHandler.hasErrors();
    }

    public void displayFormWarningsAndErrors() {
        this.astErrorHandler.displayWarningsAndErrors();
        return;
    }
}
