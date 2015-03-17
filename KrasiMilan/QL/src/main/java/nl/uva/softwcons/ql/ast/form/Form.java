package nl.uva.softwcons.ql.ast.form;

import java.util.List;

import nl.uva.softwcons.ql.ast.ASTNode;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.statement.Statement;

public class Form implements ASTNode {
    private final Identifier name;
    private final List<Statement> statements;

    public Form(final Identifier name, final List<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public Identifier getName() {
        return name;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public <T> T accept(final FormVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return name.getLineInfo();
    }

}
