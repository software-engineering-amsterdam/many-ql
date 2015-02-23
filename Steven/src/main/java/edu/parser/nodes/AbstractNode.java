package edu.parser.nodes;

import edu.parser.Visitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode {

    public AbstractNode accept(Visitor visitor);
}
