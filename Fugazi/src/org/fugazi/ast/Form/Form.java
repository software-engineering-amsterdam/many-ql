package org.fugazi.ast.Form;

import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.ast.Statement.Statement;

import java.util.List;

public class Form extends ASTNode {

    private String name;
    private List<Statement> statements;

    public Form(String name, List<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public String getName() {
        return this.name;
    }

    public List<Statement> getStatements() {
        return this.statements;
    }
}
