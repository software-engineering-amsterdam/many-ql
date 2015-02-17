package parser.ast.nodes;

import java.util.List;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class Form implements AbstractNode {

    private final List<AbstractNode> elements;

    public Form(List<AbstractNode> elements) {
        this.elements = elements;
    }

    public List<AbstractNode> getElements() {
        return elements;
    }
}
