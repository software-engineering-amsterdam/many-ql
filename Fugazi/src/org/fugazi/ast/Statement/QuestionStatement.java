package org.fugazi.ast.statement;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.literal.ID;
import org.fugazi.ast.type.Type;

public class QuestionStatement extends Statement {

    protected final Type type;
    
    protected final String label;
    
    protected final ID identifier;

    public QuestionStatement(Type _type, String _label, ID _identifier) {
        this.type = _type;
        this.label = _label;
        this.identifier = _identifier;
    }

    public Type getType() {
        return  this.type;
    }

    public String getLabel() {
        return  this.label;
    }

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
