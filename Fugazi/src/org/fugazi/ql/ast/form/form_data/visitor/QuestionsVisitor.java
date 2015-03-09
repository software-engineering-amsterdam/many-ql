package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionsVisitor implements IStatementVisitor<Void> {
    private final Form form;
    private List<Question> questions;

    public QuestionsVisitor(Form _form) {
        this.form = _form;
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    private Void visitForm() {
        List<Statement> statementList = this.form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    public Void visitQuestion(Question question) {
        this.saveQuestion(question);
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        return null;
    }

    public Void visitIfStatement(IfStatement ifStatement) {
        List<Statement> statementList = ifStatement.getBody();
        
        for (Statement statement : statementList) {
            statement.accept(this);
        }
        
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

    public List<Question> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();
            // visit the form
            this.visitForm();
        }

        return this.questions;
    }
}
