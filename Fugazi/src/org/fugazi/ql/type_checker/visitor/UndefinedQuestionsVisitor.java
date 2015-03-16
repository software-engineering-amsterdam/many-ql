package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.form.form_data.visitor.FullQLFormVisitor;
import org.fugazi.ql.ast.type.UndefinedType;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;


public class UndefinedQuestionsVisitor extends FullQLFormVisitor {
    private final QLFormDataStorage formData;

    public UndefinedQuestionsVisitor(QLFormDataStorage _formData) {
        super();
        this.formData = _formData;
    }

    @Override
    public Void visitID(ID idLiteral) {

        if (this.formData.getIdType(idLiteral).equals(new UndefinedType())) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.UNDEFINED, idLiteral,
                    "Question not defined."
            );
        }
        return null;
    }
}