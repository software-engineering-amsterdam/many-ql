package edu.parser

import edu.nodes.styles.Style
import edu.parser.QLS.nodes.QLSIdentifier
import edu.parser.QLS.nodes.statement.QLSQuestion

/**
 * Created by Steven Kok on 11/03/2015.
 */
public class QLSQuestionBuilder {
    private QLSIdentifier identifier
    private List<Style> styles

    QLSQuestionBuilder() {
        this.styles = new ArrayList<>()
        identifier = new QLSIdentifier("identifier")
    }

    public QLSQuestion build() {
        return new QLSQuestion(identifier, styles)
    }

    public QLSQuestionBuilder addStyle(Style style) {
        styles.add(style)
    }

    public QLSQuestionBuilder identifier(String identifier) {
        this.identifier = new QLSIdentifier(identifier);
    }
}
