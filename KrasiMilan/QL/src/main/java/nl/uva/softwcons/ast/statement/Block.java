package nl.uva.softwcons.ast.statement;

import java.util.List;

public class Block extends Statement {

    private List<Statement> statements;

    public Block(List<Statement> statements) {
        super();
        this.statements = statements;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<Statement> getStatements() {
        return statements;
    }

}
