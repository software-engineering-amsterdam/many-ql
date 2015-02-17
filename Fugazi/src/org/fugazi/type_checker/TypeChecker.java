package org.fugazi.type_checker;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;
//import org.fugazi.evaluator.ExpressionValue;
//import org.fugazi.evaluator.ExpressionVisitor;
//import org.fugazi.evaluator.UndefinedValue;
//import org.fugazi.evaluator.ValueStorage;

public class TypeChecker {

    // TODO ERROR HANDLER NEEDS TO BE CLEANED ON EACH CHECK
    // should it be final then?
    // or use clean method like now?
    private final ASTErrorHandler astErrorHandler;

    public TypeChecker() {
        this.astErrorHandler = new ASTErrorHandler();
    }

    // TODO should there be a separate isFormCorrect method?
    public boolean checkForm(Form form) {
        return !this.astErrorHandler.hasErrors();
    }
}
