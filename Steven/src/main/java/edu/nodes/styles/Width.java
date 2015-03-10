package edu.nodes.styles;

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
    public Width clone() throws CloneNotSupportedException {
        return new Width(width);
    }
}
