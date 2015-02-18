package nl.uva.softwcons.ast.form;

import java.util.List;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.statement.Statement;

public class Form implements ASTNode {

    private String name;
    private List<Statement> statements;

    public Form(final String name, final List<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public String getName() {
        return name;
    }

    public List<Statement> getStatements() {
        return statements;
    }

}
