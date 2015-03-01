package edu.parser.QLS.nodes;

import edu.parser.QLS.Visitor;
import edu.parser.AbstractNode;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Page implements AbstractNode<Visitor> {

    private final List<AbstractNode> sections;

    public Page(List<AbstractNode> sections) {
        this.sections = sections;
    }

    public List<AbstractNode> getSections() {
        return sections;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
