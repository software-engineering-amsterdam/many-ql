package edu.parser.QL.nodes;

import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.statement.Statement;

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

    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }
}
