package nl.uva.softwcons.ast.form;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.statement.Block;

public class Form implements ASTNode {
    private Identifier name;
    private Block body;

    public Form(final Identifier name, final Block body) {
        this.name = name;
        this.body = body;
    }

    public Identifier getName() {
        return name;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public LineInfo getLineInfo() {
        return name.getLineInfo();
    }

}
