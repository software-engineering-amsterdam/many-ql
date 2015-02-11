package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionTextNode extends Node {
    private String text;

    public QuestionTextNode(String text) {
        this.text = text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getText() {
        return text;
    }
}
