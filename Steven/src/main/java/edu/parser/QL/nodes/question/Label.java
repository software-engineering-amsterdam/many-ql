package edu.parser.QL.nodes.question;

import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Label implements AbstractNode, Cloneable {
    private final String label;

    public Label(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
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

    @Override
    public Label clone() throws CloneNotSupportedException {
        return new Label(label);
    }
}
