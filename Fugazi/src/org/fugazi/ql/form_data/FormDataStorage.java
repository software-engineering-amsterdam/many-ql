package org.fugazi.ql.form_data;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.form_data.visitor.QuestionLabelsVisitor;

import java.util.ArrayList;
import java.util.List;

public class FormDataStorage {
    private final Form form;

    private final QuestionLabelsVisitor questionLabelsVisitor;

    public FormDataStorage(Form _form) {
        this.form = _form;
        this.questionLabelsVisitor = new QuestionLabelsVisitor(this.form);
    }

    public List<String> getQuestionLabels() {
        return this.questionLabelsVisitor.getQuestionLabels();
    }
}
