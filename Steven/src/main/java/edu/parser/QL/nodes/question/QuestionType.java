package edu.parser.QL.nodes.question;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.Visitor;

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
