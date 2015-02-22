package parser.nodes;

import parser.Visitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode {

    public void accept(Visitor visitor);
}
