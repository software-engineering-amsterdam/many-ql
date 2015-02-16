package org.fugazi.ast.form;

import org.fugazi.ast.AbstractASTNode;
import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.statement.Statement;

import java.util.List;

public class Form extends AbstractASTNode {

    private final String name;

    private final List<Statement> body;

    public Form(String _name, List<Statement> _body) {
        this.name = _name;
        this.body = _body;
    }

    public String getName() {
        return this.name;
    }

    public List<Statement> getBody() {
        return this.body;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitForm(this);
    }
}
