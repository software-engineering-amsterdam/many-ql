package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.form.form_data.visitor.FullQLFormVisitor;
import org.fugazi.ql.ast.type.UndefinedType;
import org.fugazi.ql.type_checker.issue.error.UndefinedQuestionError;


public class UndefinedQuestionsVisitor extends FullQLFormVisitor {

    public UndefinedQuestionsVisitor(QLFormDataStorage _formData) {
        super(_formData);
    }

    @Override
    public Void visitID(ID idLiteral) {

        if (this.formData.getIdType(idLiteral).equals(new UndefinedType())) {
            this.astIssueHandler.registerNewError(
                    new UndefinedQuestionError(), idLiteral,
                    "Question not defined."
            );
        }
        return null;
    }
}