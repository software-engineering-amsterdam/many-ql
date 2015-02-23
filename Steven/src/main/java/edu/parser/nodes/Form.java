package edu.parser.nodes;

import edu.parser.nodes.statement.Statement;
import edu.parser.Visitor;

import java.util.List;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class Form implements AbstractNode {

    private final List<Statement> elements;

    public Form(List<Statement> elements) {
        this.elements = elements;
    }

    public List<Statement> getElements() {
        return elements;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
