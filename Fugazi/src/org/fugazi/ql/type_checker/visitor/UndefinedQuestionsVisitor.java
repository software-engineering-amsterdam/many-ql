package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.visitor.FullQLFormVisitor;
import org.fugazi.ql.type_checker.helper.QLTypeCheckerHelper;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;


public class UndefinedQuestionsVisitor extends FullQLFormVisitor {

    public UndefinedQuestionsVisitor() {
        super();
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
        boolean questionDefined = QLTypeCheckerHelper.isDefined(idLiteral);
        if (!questionDefined) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.UNDEFINED, idLiteral,
                    "Question not defined."
            );
        }
        return null;
    }
}