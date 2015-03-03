package edu.parser.QLS.nodes.styles;

import edu.Widgets;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Widget extends Style {
    private final Widgets widget;

    public Widget(Widgets widget) {
        this.widget = widget;
    }

    public Widgets getWidget() {
        return widget;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
