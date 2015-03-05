package edu.parser.QL.nodes;

import edu.parser.QL.QLVisitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode {

    public AbstractNode accept(QLVisitor visitor);
}

