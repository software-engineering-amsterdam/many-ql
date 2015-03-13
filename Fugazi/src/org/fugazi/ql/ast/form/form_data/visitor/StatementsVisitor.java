package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;

import java.util.List;

/*
 This class performs a full AST Tree STATEMENTS traversal.
 Class can inherit and override methods where they
 need to perform additional actions.
 */
public abstract class StatementsVisitor implements IStatementVisitor<Void> {
    protected final Form form;

    public StatementsVisitor(Form _form) {
        this.form = _form;
    }

    public Void visitForm() {
        List<Statement> statementList = this.form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    public Void visitQuestion(Question question) {
        return null;
    }

    public Void visitIfStatement(IfStatement ifStatement) {
        List<Statement> statementList = ifStatement.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        return null;
    }
}
