package nl.uva.softwcons.ql.ast.statement;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;

public class Question extends Statement {

    private Identifier id;
    private String label;
    private Type type;

    public Question(final Identifier id, final String label, final Type type) {
        this.id = id;
        this.label = label;
        this.type = type;
    }

    public Identifier getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return id.getLineInfo();
    }

}
