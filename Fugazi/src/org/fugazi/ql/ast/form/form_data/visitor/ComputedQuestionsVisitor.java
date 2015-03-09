package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

public class ComputedQuestionsVisitor extends StatementsVisitor {
    private List<ComputedQuestion> computedQuestions;

    public ComputedQuestionsVisitor(Form _form) {
        super(_form);
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        this.saveComputedQuestion(assignQuest);
        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveComputedQuestion(ComputedQuestion question) {
        this.computedQuestions.add(question);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<ComputedQuestion> getComputedQuestions() {
        if (this.computedQuestions == null) {
            this.computedQuestions= new ArrayList<>();

            this.visitForm();
        }

        return this.computedQuestions;
    }
}
