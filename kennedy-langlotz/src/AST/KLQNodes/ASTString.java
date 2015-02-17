package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class ASTString extends Node {
    private String string;

    public ASTString(String string) {
        this.string = string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getString() {
        return string;
    }
}
