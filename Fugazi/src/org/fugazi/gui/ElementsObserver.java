package org.fugazi.gui;

import org.fugazi.gui.ui_elements.UIElement;

import java.util.Observer;
import java.util.Observable;

public class ElementsObserver implements Observer {

    public ElementsObserver() {
    }

    public void update(Observable o, Object arg) {
        //TODO: beautiful
        UIElement uiQuestion = (UIElement) o;
        System.out.println(uiQuestion.getState().getValue());
    }
}
