package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

public class IfStatementsVisitor implements IStatementVisitor<Void> {
    private final Form form;
    private List<IfStatement> statements;

    public IfStatementsVisitor(Form _form) {
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
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        return null;
    }

    public Void visitIfStatement(IfStatement ifStatement) {
        this.saveIfStatement(ifStatement);
        return null;}

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveIfStatement(IfStatement statement) {
        this.statements.add(statement);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<IfStatement> getIfStatement() {
        if (this.statements == null) {
            this.statements = new ArrayList<>();
            // visit the form
            this.visitForm();
        }

        return this.statements;
    }
}

