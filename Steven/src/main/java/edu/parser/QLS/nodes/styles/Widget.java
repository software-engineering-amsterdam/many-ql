package edu.parser.QLS.nodes.styles;

import edu.parser.AbstractNode;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Widget extends Style {
    private final String widget;

    public Widget(String widget) {
        this.widget = widget;
    }

    public String getWidget() {
        return widget;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
