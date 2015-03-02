package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.styles.Style;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Question extends Statement {
    private final List<Style> styles;
    private final Identifier identifier;

    public Question(Identifier identifier, List<Style> styles) {
        this.styles = styles;
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<Style> getStyles() {
        return styles;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
