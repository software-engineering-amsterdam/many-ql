package org.fugazi.ast.Form;

import org.fugazi.ast.ASTNode.AbstractASTNode;
import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.Statement.Statement;

import java.util.ArrayList;

/**
 * The form class, this class represents the 'form' statement.
 * It is the root Node of the AST.
 */
public class Form extends AbstractASTNode {

    // Name of the form
    private String name;
    
    // The list of the statements the form has.
    private ArrayList<Statement> statements;

    /**
     * Constructor.
     *
     * @param _name the form's name
     * @param _statements the statements of the form.
     */
    public Form(String _name, ArrayList<Statement> _statements) {
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
    public ArrayList<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitForm(this);
    }
}
