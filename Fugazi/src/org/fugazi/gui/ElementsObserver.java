package org.fugazi.gui;

import org.fugazi.gui.ui_elements.UIQuestion;

import java.util.Observer;
import java.util.Observable;

/**
 * Observes the UIQuestions
 */
public class ElementsObserver implements Observer {

    public ElementsObserver() {
    }

    public void update(Observable o, Object arg) {
        //TODO: beautiful
        UIQuestion uiQuestion = (UIQuestion) o;
        System.out.println(uiQuestion.getId().getName() + " : " + uiQuestion.getState().getValue());
    }
}
