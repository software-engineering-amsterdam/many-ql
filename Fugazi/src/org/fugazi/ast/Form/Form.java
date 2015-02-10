package org.fugazi.ast.Form;

import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.ast.Statement.Statement;

import java.util.List;

/**
 * The form class, this class represents the 'form' statement.
 * It is the root Node of the AST.
 */
public class Form extends ASTNode {

    // Name of the form
    private String name;
    
    // The list of the statements the form has.
    private List<Statement> statements;

    /**
     * Constructor.
     *
     * @param _name the form's name
     * @param _statements the statements of the form.
     */
    public Form(String _name, List<Statement> _statements) {
        this.name = _name;
        this.statements = _statements;
    }

    /**
     * Get the form's name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the form's statements.
     * @return statements list.
     */
    public List<Statement> getStatements() {
        return this.statements;
    }
}
