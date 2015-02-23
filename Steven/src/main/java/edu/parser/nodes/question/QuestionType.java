package edu.parser.nodes.question;

import edu.parser.nodes.AbstractNode;
import edu.parser.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public enum QuestionType implements AbstractNode {
    STRING(), INTEGER(), BOOLEAN(), DATE(), MONEY(), DECIMAL();

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
