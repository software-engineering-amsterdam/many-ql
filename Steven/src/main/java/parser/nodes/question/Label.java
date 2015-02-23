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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label1 = (Label) o;

        if (!label.equals(label1.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
