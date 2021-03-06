package edu.parser.QLS.nodes.statement;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.QLSIdentifier;
import edu.nodes.styles.Style;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class QLSQuestion extends Statement {
    private final List<Style> styles;
    private final QLSIdentifier QLSIdentifier;

    public QLSQuestion(QLSIdentifier QLSIdentifier, List<Style> styles) {
        this.styles = styles;
        this.QLSIdentifier = QLSIdentifier;
    }

    public QLSIdentifier getQLSIdentifier() {
        return QLSIdentifier;
    }

    public List<Style> getStyles() {
        return styles;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "QLSQuestion{" +
                "identifier=" + QLSIdentifier +
                '}';
    }
}
