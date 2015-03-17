package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ComputedQuestionsVisitor extends StatementsVisitor {
    private HashMap<String, Type> computedQuestionTypes;
    private List<ComputedQuestion> computedQuestions;

    public ComputedQuestionsVisitor(Form _form) {
        super(_form);
        this.computedQuestions = new ArrayList<>();
        this.computedQuestionTypes = new HashMap<>();
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitComputedQuestion(ComputedQuestion question) {
        this.saveComputedQuestion(question);
        this.saveQuestionType(question);
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

    private void saveQuestionType(Question question) {
        String idName = question.getIdName();
        Type type = question.getType();
        this.computedQuestionTypes.put(idName, type);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public Iterator<ComputedQuestion> getComputedQuestions() {
        if (this.computedQuestions.isEmpty()) {
            this.visitForm();
        }
        return this.computedQuestions.iterator();
    }

    public HashMap<String, Type> getComputedQuestionTypes() {
        if (this.computedQuestionTypes.keySet().isEmpty()) {
            this.visitForm();
        }
        return this.computedQuestionTypes;
    }
}

