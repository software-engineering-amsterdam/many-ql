package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionIdentifierNode extends Node {
    private String identifier;

    public QuestionIdentifierNode(String identifier){
        this.identifier = identifier;

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }
}
