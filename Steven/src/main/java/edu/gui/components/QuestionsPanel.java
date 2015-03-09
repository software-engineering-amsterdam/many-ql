package edu.gui.components;

import edu.exceptions.GuiException;
import edu.gui.Observer;
import edu.gui.QuestionTypeGui;
import edu.gui.Subject;
import edu.nodes.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class QuestionsPanel extends JPanel {

    private final GridBagConstraints gbc;
    private final List<Question> questions;
    private final Observer questionState;

    public QuestionsPanel(List<Question> questions, Observer questionState) {
        this.questionState = questionState;
        this.questions = questions;
        gbc = new GridBagConstraints();
        initializeGridBagLayout();
        addQuestionsToGridBagLayout();
    }

    private void initializeGridBagLayout() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 5, 2, 5); // padding
        gbc.weightx = gbc.weighty = 1.0; // fill available space
    }

    private void addQuestionsToGridBagLayout() {
        questions.stream()
                .forEachOrdered(this::addQuestionToGridBagLayout);
    }

    private void addQuestionToGridBagLayout(Question question) {
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        addLabel(question);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        addInputField(question);
        gbc.gridy++;
    }

    private void addLabel(Question question) {
        String label = question.getLabel().getLabel();
        add(new JLabel(label), gbc);
    }

    private void addInputField(Question question) {
        try {
            Subject component = QuestionTypeGui.getComponent(question.getQuestionType());
            component.registerObserver(questionState);
            add((JComponent) component, gbc);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new GuiException("Could not create input field for: " + question, e);
        }
    }
}
