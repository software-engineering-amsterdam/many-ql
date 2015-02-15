package nl.uva.softwcons.ast.statement;

import nl.uva.softwcons.ast.type.Type;

public class Question extends Statement {

    private String id;
    private String label;
    private Type type;

    public Question(final String id, final String label, final Type type) {
        this.id = id;
        this.label = label;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

}
