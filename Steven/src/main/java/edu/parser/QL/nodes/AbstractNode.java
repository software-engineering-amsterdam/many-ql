package edu.parser.QL.nodes;

import edu.parser.QL.QLVisitor;

/**
 * Created by Steven Kok on 17/02/2015.
 *
 * @apiNote Every concrete implementation must be immutable. Otherwise the Cloneable interface must be implemented for every implementation.
 */
public interface AbstractNode {

    public AbstractNode accept(QLVisitor visitor);
}

