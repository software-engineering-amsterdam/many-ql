package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;
import edu.parser.QL.nodes.expression.Identifier;
import edu.parser.QL.nodes.question.Question;

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
    private final Question question;

    public CheckBox(Question question) {
        this.addActionListener(this);
        setText("yes");
        setSelected(question.isEnabled());
        setEnabled(true);
        this.question = question;
    }

    public Identifier getIdentifier() {
        return question.getIdentifier();
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
