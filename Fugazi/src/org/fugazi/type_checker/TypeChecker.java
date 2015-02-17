package org.fugazi.type_checker;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;

import java.util.ArrayList;

/*
// TODO type checker detect
reference to undefined questions
duplicate question declarations with different types
conditions that are not of the type boolean
operands of invalid type to operators
cyclic dependencies between questions
duplicate labels (warning)
 */

public class TypeChecker {

    // TODO ERROR HANDLER NEEDS TO BE CLEANED ON EACH CHECK
    // should it be final then?
    // or use clean method like now?
    private final ASTErrorHandler astErrorHandler;

    public TypeChecker() {
        this.astErrorHandler = new ASTErrorHandler();
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    // TODO should there be a separate isFormCorrect method?
    public boolean checkForm(Form form) {
        return !this.astErrorHandler.hasErrors();
    }

    public void displayFormWarningsAndErrors() {
        this.astErrorHandler.displayWarningsAndErrors();
        return;
    }
}
