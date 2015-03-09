package org.fugazi.ql.ast.form.form_data;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.form.form_data.visitor.ComputedQuestionsVisitor;
import org.fugazi.ql.ast.form.form_data.visitor.IfStatementsVisitor;
import org.fugazi.ql.ast.form.form_data.visitor.QuestionsVisitor;

import java.util.List;

public class QLFormDataStorage {
    private final Form form;

    private final QuestionsVisitor questionsVisitor;
    private final ComputedQuestionsVisitor computedQuestionsVisitor;
    private final IfStatementsVisitor ifStatementsVisitor;

    public QLFormDataStorage(Form _form) {
        this.form = _form;

        this.questionsVisitor = new QuestionsVisitor(this.form);
        this.computedQuestionsVisitor = new ComputedQuestionsVisitor(this.form);
        this.ifStatementsVisitor = new IfStatementsVisitor(this.form);
    }

    /**
     * =====================
     * Public exposed getters
     * =====================
     */


    public List<Question> getQuestions() {
        return this.questionsVisitor.getQuestions();
    }

    public List<ComputedQuestion> getComputedQuestions() {
        return this.computedQuestionsVisitor.getComputedQuestions();
    }

    public List<Question> getAllQuestions() {
        List<Question> allQuestions = this.getQuestions();
        List<ComputedQuestion> computedQuestions = this.getComputedQuestions();
        allQuestions.addAll(computedQuestions);

        return allQuestions;
    }

    public List<IfStatement> getIfStatements() {
        return this.ifStatementsVisitor.getIfStatement();
    }
}
