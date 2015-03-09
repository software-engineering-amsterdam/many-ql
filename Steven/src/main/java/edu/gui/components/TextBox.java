package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;

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

    public TextBox() {
        this.addFocusListener(this);
        setColumns(15);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
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
