package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionsVisitor extends StatementsVisitor {
    private List<Question> questions;

    public QuestionsVisitor(Form _form) {
        super(_form);
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitQuestion(Question question) {
        this.saveQuestion(question);
        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public Iterator<Question> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();

            this.visitForm();
        }
        return this.questions.iterator();
    }
}
