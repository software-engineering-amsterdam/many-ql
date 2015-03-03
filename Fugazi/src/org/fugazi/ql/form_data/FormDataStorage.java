package org.fugazi.ql.form_data;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.form_data.visitor.QuestionLabelsVisitor;
import org.fugazi.ql.form_data.visitor.QuestionTypesVisitor;

import java.util.List;
import java.util.Map;

public class FormDataStorage {
    private final Form form;

    private final QuestionLabelsVisitor questionLabelsVisitor;
    private final QuestionTypesVisitor questionTypesVisitor;

    public FormDataStorage(Form _form) {
        this.form = _form;

        this.questionLabelsVisitor = new QuestionLabelsVisitor(this.form);
        this.questionTypesVisitor = new QuestionTypesVisitor(this.form);
    }

    public List<String> getQuestionLabels() {
        return this.questionLabelsVisitor.getQuestionLabels();
    }

    public Map<String, Type> getQuestionTypes() {
        return this.questionTypesVisitor.getQuestionTypes();
    }
}
