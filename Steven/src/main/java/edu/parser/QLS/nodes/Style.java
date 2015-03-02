package edu.parser.QLS.nodes;

import edu.parser.QLS.Visitor;
import edu.parser.AbstractNode;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Style implements AbstractNode<Visitor> {
    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
