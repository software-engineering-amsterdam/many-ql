package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class IfStatementsVisitor extends StatementsVisitor {
    private List<IfStatement> statements;

    public IfStatementsVisitor(Form _form) {
        super(_form);
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitIfStatement(IfStatement ifStatement) {
        this.saveIfStatement(ifStatement);

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

            this.visitForm();
        }

        return this.statements;
    }
}

