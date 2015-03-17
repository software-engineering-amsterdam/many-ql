package org.fugazi.ql.ast.form;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.IASTVisitor;
import org.fugazi.ql.ast.statement.Statement;
import org.fugazi.ql.ast.type.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitForm(this);
    }
}
