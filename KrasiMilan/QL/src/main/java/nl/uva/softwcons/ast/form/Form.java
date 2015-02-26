package nl.uva.softwcons.ast.form;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.statement.Block;

public class Form implements ASTNode {
    private String name;
    private Block body;
    private LineInfo lineInfo;

    public Form(final String name, final Block body, final LineInfo lineInfo) {
        this.name = name;
        this.body = body;
        this.lineInfo = lineInfo;
    }

    public String getName() {
        return name;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public LineInfo getLineInfo() {
        return this.lineInfo;
    }

}
