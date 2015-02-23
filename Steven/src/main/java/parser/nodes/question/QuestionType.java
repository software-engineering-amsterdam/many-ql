package parser.nodes.question;

import parser.nodes.AbstractNode;
import parser.Visitor;

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
