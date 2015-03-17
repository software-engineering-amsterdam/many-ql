package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;
import org.fugazi.ql.ast.type.Type;

import java.util.*;

public class QuestionsVisitor extends StatementsVisitor {
    private List<Question> questions;
    private HashMap<String, Type> questionTypes;

    public QuestionsVisitor(Form _form) {
        super(_form);
        this.questions = new ArrayList<>();
        this.questionTypes = new HashMap<>();
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitQuestion(Question question) {
        this.saveQuestion(question);
        this.saveQuestionType(question);
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

    private void saveQuestionType(Question question) {
        String idName = question.getIdName();
        Type type = question.getType();
        this.questionTypes.put(idName, type);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public Iterator<Question> getQuestions() {
        if (this.questions.isEmpty()) {
            this.visitForm();
        }
        return this.questions.iterator();
    }

    public HashMap<String, Type> getQuestionTypes() {
        if (this.questionTypes.keySet().isEmpty()) {
            this.visitForm();
        }
        return this.questionTypes;
    }
}
