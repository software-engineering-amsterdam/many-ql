package edu.gui.components.store;

/**
 * Created by Steven Kok on 10/03/2015.
 */
public class TextStore implements Store {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
