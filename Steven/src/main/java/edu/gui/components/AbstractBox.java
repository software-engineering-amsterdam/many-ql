package edu.gui.components;

import edu.gui.Observer;
import edu.gui.Subject;
import edu.parser.QL.nodes.expression.QLIdentifier;
import edu.parser.QL.nodes.question.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 13/03/2015.
 */
public abstract class AbstractBox implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private final Question question;

    public AbstractBox(Question question) {
        this.question = question;
    }

    protected Question getQuestion() {
        return question;
    }

    protected List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    protected boolean computedQuestion(Question question) {
        return question.getExpression().isPresent();
    }

    public QLIdentifier getIdentifier() {
        return question.getQLIdentifier();
    }

    public abstract void removeEventListeners();
}
