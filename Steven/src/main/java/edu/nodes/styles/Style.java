package edu.nodes.styles;

import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.AbstractNode;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public abstract class Style implements AbstractNode, Cloneable {
    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }

    @Override
    public abstract Style clone() throws CloneNotSupportedException;
}
