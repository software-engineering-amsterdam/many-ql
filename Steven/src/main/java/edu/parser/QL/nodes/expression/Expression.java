package edu.parser.QL.nodes.expression;

import edu.parser.QL.QLVisitor;
import edu.parser.AbstractNode;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class Expression implements AbstractNode<QLVisitor> {

    public abstract boolean hasBooleanOperands();
}
