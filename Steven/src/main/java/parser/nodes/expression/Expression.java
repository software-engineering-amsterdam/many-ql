package parser.nodes.expression;

import parser.nodes.AbstractNode;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class Expression implements AbstractNode {

    public abstract boolean isConditional();
}
