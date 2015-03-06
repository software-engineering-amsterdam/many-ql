package edu.parser.nodes.styles;

import edu.Widgets;

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

}
