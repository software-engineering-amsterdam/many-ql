package edu.gui;


import edu.gui.components.store.Store;

/**
 * Created by Steven Kok on 09/03/2015.
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

    public Store getStore();
}
