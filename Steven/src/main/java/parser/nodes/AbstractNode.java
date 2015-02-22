package parser.nodes;

import typeChecker.Visitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode {

    public void accept(Visitor visitor);
}
