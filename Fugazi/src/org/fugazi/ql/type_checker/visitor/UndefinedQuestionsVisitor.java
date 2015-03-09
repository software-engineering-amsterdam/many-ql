package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.visitor.FullFormVisitor;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

import java.util.List;

public class UndefinedQuestionsVisitor extends FullFormVisitor {

    private final ASTIssueHandler astIssueHandler;

    public UndefinedQuestionsVisitor() {
        super();
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Void visitID(ID idLiteral) {
        // check if variable defined
        // if it's type equals null => it is undefined
        boolean questionDefined = this.checkIfDefined(idLiteral);
        if (!questionDefined) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.UNDEFINED, idLiteral,
                    "Question not defined."
            );
        }
        return null;
    }

    /**
     * =======================
     * Internal check methods
     * =======================
     */

    private boolean checkIfDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    /**
     * =======================
     * Exposed general form functions
     * =======================
     */

    public List<ASTNodeIssue> getErrors() {
        return this.astIssueHandler.getErrors();
    }
}
