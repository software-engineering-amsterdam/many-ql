package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;
import edu.parser.QL.nodes.expression.QLIdentifier;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class TextBox extends JTextField implements Subject, FocusListener {
    private final List<Observer> observers = new ArrayList<>();
    private final QLIdentifier QLIdentifier;

    public TextBox(QLIdentifier QLIdentifier) {
        this.addFocusListener(this);
        setColumns(15);
        this.QLIdentifier = QLIdentifier;
    }

    public QLIdentifier getQLIdentifier() {
        return QLIdentifier;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        observer.initializeRequest(this);
    }

    @Override
    public void notifyObservers() {
        observers.stream()
                .forEach(observer -> observer.update(this));
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        notifyObservers();
    }

}
