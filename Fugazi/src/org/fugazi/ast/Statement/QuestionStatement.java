package org.fugazi.ast.Statement;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Type.Type;

/**
 * The Question class.
 * It is a Node of the AST, and a statement.
 */
public class QuestionStatement extends Statement {

    // The type of the question.
    protected Type type;
    
    // The displayed label of the question.
    protected String label;
    
    // The questions identifier/variable name.
    protected ID identifier;

    /**
     * Constructor.
     * @param _type the question type
     * @param _label the question display label
     * @param _identifier the question identifier
     */
    public QuestionStatement(Type _type, String _label, ID _identifier) {
        this.type = _type;
        this.label = _label;
        this.identifier = _identifier;
    }

    /**
     * Get the type
     * @return type
     */
    public Type getType() {
        return  this.type;
    }

    /**
     * Get the label
     * @return label
     */
    public String getLabel() {
        return  this.label;
    }

    /**
     * Get the Identifier
     * @return identifier
     */
    public ID getIdentifier() {
        return this.identifier;
    }

    @Override
    public String toString() {
        return this.type.toString() + this.identifier.toString() + " " + "('" + this.label + "')";
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitQuestionStatement(this);
    }
}
