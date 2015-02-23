package parser.nodes.question;

import parser.nodes.AbstractNode;
import parser.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Label implements AbstractNode {
    private final String label;

    public Label(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
