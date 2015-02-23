package org.fugazi.type_checker;

import org.fugazi.ast.form.Form;
//import org.fugazi.evaluator.ExpressionValue;
//import org.fugazi.evaluator.visitor.ExpressionVisitor;
//import org.fugazi.evaluator.UndefinedValue;
//import org.fugazi.evaluator.ValueStorage;


/*
// TODO type checker must detect
cyclic dependencies between questions
 */

public class TypeChecker {

    // TODO ERROR HANDLER NEEDS TO BE CLEANED ON EACH CHECK
    // should it be final then?
    // or use clean method like now?
    private final TypeCheckerVisitor visitor;

    public TypeChecker() {

        this.visitor = new TypeCheckerVisitor();
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

//    // TODO should there be a separate isFormCorrect method?
    public boolean checkForm(Form form) {
        form.accept(this.visitor);
        return this.visitor.isFormCorrect();
    }

    public void displayFormWarningsAndErrors() {
        this.visitor.displayFormWarningsAndErrors();
        return;
    }
}
