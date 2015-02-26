package nl.uva.softwcons.ast.statement;

import java.util.List;

import nl.uva.softwcons.ast.LineInfo;

public class Block extends Statement {

    private List<Statement> statements;
    private LineInfo lineInfo;

    public Block(List<Statement> statements, LineInfo lineInfo) {
        this.statements = statements;
        this.lineInfo = lineInfo;
    }

    public List<Statement> getStatements() {
        return statements;
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
