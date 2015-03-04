package org.fugazi.ql.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

public class ComputedQuestionsVisitor implements IStatementVisitor<Void> {
    private final Form form;
    private List<ComputedQuestion> computedQuestions;

    public ComputedQuestionsVisitor(Form _form) {
        this.form = _form;
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    // TODO why doesn't this.form.accept() work?
    private Void visitForm() {
        List<Statement> statementList = this.form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        this.saveComputedQuestion(assignQuest);
        return null;
    }

    public Void visitQuestion(Question question) {return null;}
    public Void visitIfStatement(IfStatement ifStatement) {return null;}

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
            // visit the form
            this.visitForm();
        }

        return this.computedQuestions;
    }
}
