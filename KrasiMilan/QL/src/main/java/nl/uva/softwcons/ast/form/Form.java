package nl.uva.softwcons.ast.form;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.statement.Block;

public class Form implements ASTNode {

    private String name;
    private Block body;

    public Form(final String name, final Block body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public Block getBody() {
        return body;
    }

}
