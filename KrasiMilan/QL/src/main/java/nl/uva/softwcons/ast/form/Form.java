package nl.uva.softwcons.ast.form;

import java.util.List;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.statement.Statement;

public class Form implements ASTNode {
    private Identifier name;
    private List<Statement> statements;

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

    public <T> T accept(FormVisitor<T> visitor) {
        return visitor.visitForm(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return name.getLineInfo();
    }

}
