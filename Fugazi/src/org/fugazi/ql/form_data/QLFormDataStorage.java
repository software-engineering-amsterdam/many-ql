package org.fugazi.ql.form_data;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.form_data.visitor.QuestionsVisitor;

import java.util.List;

public class QLFormDataStorage {
    private final Form form;

    private final QuestionsVisitor questionsVisitor;

    public QLFormDataStorage(Form _form) {
        this.form = _form;

        this.questionsVisitor = new QuestionsVisitor(this.form);
    }

    public List<Question> getQuestions() {
        return this.questionsVisitor.getQuestionLabels();
    }
}
