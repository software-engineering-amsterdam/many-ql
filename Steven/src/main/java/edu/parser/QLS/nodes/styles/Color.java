package edu.parser.QLS.nodes.styles;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Color extends Style {

    private final int color;

    public Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
