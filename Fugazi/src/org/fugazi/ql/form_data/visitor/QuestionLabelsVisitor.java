package org.fugazi.ql.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionLabelsVisitor implements IStatementVisitor<Void> {
    private final Form form;
    private List<String> questionLabels;

    public QuestionLabelsVisitor(Form _form) {
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

    public Void visitQuestion(Question question) {
        this.saveQuestionLabel(question.getLabel());
        return null;
    }

    public Void visitIfStatement(IfStatement ifStatement) {return null;}
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {return null;}

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestionLabel(String label) {
        this.questionLabels.add(label);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<String> getQuestionLabels() {
        if (this.questionLabels == null) {
            this.questionLabels = new ArrayList<>();
            // visit the form
            this.visitForm();
        }

        return this.questionLabels;
    }
}
