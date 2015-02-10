package org.fugazi.ast.Statement;

import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Type.Type;

import java.net.IDN;

public class QuestionStatement extends Statement {

    private Type type;
    private String label;
    private ID identifier;

    public QuestionStatement(Type type, String label, ID identifier) {
        this.type = type;
        this.label = label;
        this.identifier = identifier;
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
}
