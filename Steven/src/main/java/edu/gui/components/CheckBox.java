package edu.gui.components;

import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class CheckBox extends AbstractBox implements ActionListener {
    private final JCheckBox jCheckBox;

    public CheckBox(Question question) {
        super(question);
        jCheckBox = new JCheckBox();
        jCheckBox.addActionListener(this);
        jCheckBox.setText("yes");
        jCheckBox.setEnabled(true);
        initialize();
    }

    public void initialize() {
        jCheckBox.setSelected(getQuestion().isEnabled());
    }

    @Override
    public void removeEventListeners() {
        jCheckBox.removeActionListener(this);
    }

    @Override
    public void notifyObservers() {
        getObservers().stream()
                .forEach(observer -> observer.update(this));
    }

    @Override
    public JComponent getComponent() {
        return jCheckBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }

    public boolean isSelected() {
        return jCheckBox.isSelected();
    }
}
