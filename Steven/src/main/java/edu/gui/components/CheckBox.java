package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;
import edu.gui.components.store.DefaultStore;
import edu.gui.components.store.Store;
import edu.parser.QL.nodes.expression.QLIdentifier;

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
    private final QLIdentifier QLIdentifier;

    public CheckBox(QLIdentifier QLIdentifier) {
        this.addActionListener(this);
        setText("yes");

        setEnabled(true);
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
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream()
                .forEach(observer -> observer.update(this));
    }

    @Override
    public Store getStore() {
        return new DefaultStore();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }

}
