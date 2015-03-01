package edu.parser.QL.nodes.expression;

import edu.parser.QL.Visitor;
import edu.parser.AbstractNode;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class Expression implements AbstractNode<Visitor> {

    public abstract boolean hasBooleanOperands();
}
