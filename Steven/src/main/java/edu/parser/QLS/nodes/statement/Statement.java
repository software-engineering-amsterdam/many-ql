package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;
import edu.parser.QLS.nodes.styles.Style;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public abstract class Statement implements AbstractNode<Visitor> {

    private final List<Style> styles;

    protected Statement(List<Style> styles) {
        this.styles = styles;
    }

    public List<Style> getStyles() {
        return styles;
    }


}
