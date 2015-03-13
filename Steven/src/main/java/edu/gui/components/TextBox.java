package edu.gui.components;

import edu.gui.Subject;
import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class TextBox extends AbstractBox implements Subject, FocusListener {

    private final JTextField jTextField;

    public TextBox(Question question) {
        super(question);
        jTextField = new JTextField();
        jTextField.addFocusListener(this);
        jTextField.setColumns(15);
        initialize();
    }

    private void initialize() {
        jTextField.setText(getQuestion().getValue().getValue());
        if (computedQuestion(getQuestion())) {
            jTextField.setEditable(false);
            this.removeEventListeners();
        }
    }

    @Override
    public void removeEventListeners() {
        this.jTextField.removeFocusListener(this);
    }

    @Override
    public void notifyObservers() {
        getObservers().stream()
                .forEach(observer -> observer.update(this));
    }

    @Override
    public JComponent getComponent() {
        return jTextField;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        notifyObservers();
    }

    public String getText() {
        return jTextField.getText();
    }
}
