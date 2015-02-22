package parser.nodes;

import parser.nodes.statement.Statement;
import parser.Visitor;

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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
