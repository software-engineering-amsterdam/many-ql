package edu.parser.QLS.nodes.styles;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Width extends Style {
    private final int width;

    public Width(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
