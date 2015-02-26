package nl.uva.softwcons.ast.statement;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.type.Type;

public class Question extends Statement {

    private String id;
    private String label;
    private Type type;
    private LineInfo lineInfo;

    public Question(final String id, final String label, final Type type, final LineInfo lineInfo) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.lineInfo = lineInfo;
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

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
