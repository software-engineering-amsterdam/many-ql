package edu.gui;


import javax.swing.*;

/**
 * Created by Steven Kok on 09/03/2015.
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void notifyObservers();

    public JComponent getComponent();
}
