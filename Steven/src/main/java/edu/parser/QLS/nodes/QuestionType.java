package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class QuestionType implements AbstractNode<Visitor> {
    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
