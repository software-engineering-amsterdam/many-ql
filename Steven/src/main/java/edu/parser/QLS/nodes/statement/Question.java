package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Style;

import java.util.Optional;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Question extends Statement {

    private final Identifier identifier;

    protected Question(Identifier identifier, Optional<Style> style) {
        super(style);
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
