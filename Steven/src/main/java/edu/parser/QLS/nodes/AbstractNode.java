package edu.parser.QLS.nodes;

import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode {

    public AbstractNode accept(QLSVisitor visitor);
}

