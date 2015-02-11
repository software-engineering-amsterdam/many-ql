package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class StringNode extends Node {
    private String string;

    public StringNode(String string) {
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
