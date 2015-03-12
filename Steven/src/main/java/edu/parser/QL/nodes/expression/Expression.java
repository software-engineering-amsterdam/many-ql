package edu.parser.QL.nodes.expression;


import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class Expression implements AbstractNode {

    public abstract boolean hasBooleanOperands();
}
