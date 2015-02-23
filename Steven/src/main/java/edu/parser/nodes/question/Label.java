package edu.parser.nodes.question;

import edu.parser.nodes.AbstractNode;
import edu.parser.Visitor;

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

        return label.equals(label1.label);

    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
