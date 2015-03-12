package edu.gui.components.store;

/**
 * Created by Steven Kok on 10/03/2015.
 */
public class NumberStore implements Store {

    private final int number;

    public NumberStore(int number) {
        this.number = number;
    }

    @Override
    public String getValue() {
        return String.valueOf(number);
    }
}
