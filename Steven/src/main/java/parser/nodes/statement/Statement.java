package parser.nodes.statement;

import parser.nodes.AbstractNode;
import typeChecker.Visitor;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class Statement implements AbstractNode {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
