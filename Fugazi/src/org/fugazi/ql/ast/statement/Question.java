package org.fugazi.ql.ast.statement;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.type.Type;

public class Question extends Statement {

    protected final Type type;
    
    protected final String label;
    
    protected final ID identifier;

    public Question(Type _type, String _label, ID _identifier, int _lineNum) {
        super(_lineNum);

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

    public String getIdName() {
        return this.identifier.getName();
    }

    @Override
    public String toString() {
        return this.type.toString() + " " + this.identifier.toString() + " " + "('" + this.label + "')";
    }

    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visitQuestion(this);
    }
}
