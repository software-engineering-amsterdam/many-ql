package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.visitor.QLTypeCheckerVisitor;

import java.util.List;


public class QLTypeChecker {
    private final QLTypeCheckerVisitor visitor;

    public QLTypeChecker() {
        this.visitor = new QLTypeCheckerVisitor();
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

    public List<ASTNodeIssue> getErrors() {
        return this.visitor.getErrors();
    }

    public List<ASTNodeIssue> getWarnings() {
        return this.visitor.getWarnings();
    }
}
