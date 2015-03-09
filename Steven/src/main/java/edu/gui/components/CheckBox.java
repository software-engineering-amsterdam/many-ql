package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class CheckBox extends JCheckBox implements Subject, ActionListener {
    private final List<Observer> observers = new ArrayList<>();

    public CheckBox() {
        this.addActionListener(this);
        setText("yes");
        setSelected(false);
        setEnabled(true);
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
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }
}
