package edu.gui.components;

import edu.exceptions.GuiException;
import edu.gui.QuestionTypeGui;
import edu.nodes.Question;
import edu.nodes.styles.Style;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class QuestionsPanel extends JPanel {

    private final GridBagConstraints gbc;
    private final Map<Question, List<Style>> questions;

    public QuestionsPanel(Map<Question, List<Style>> questions) {
        this.questions = questions;
        gbc = new GridBagConstraints();
        initializeGridBagLayout();
        addQuestionsToGridBagLayout();
    }

    private void initializeGridBagLayout() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
    }

    private void addQuestionsToGridBagLayout() {
        questions.keySet().stream()
                .forEachOrdered(this::addQuestionToGridBagLayout);
    }

    private void addQuestionToGridBagLayout(Question question) {
        gbc.gridx = 0;
        addLabel(question);
        gbc.gridx++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addInputField(question);
        gbc.gridy++;
    }

    private void addLabel(Question question) {
        String label = question.getLabel().getLabel();
        add(new JLabel(label), gbc);
    }

    private void addInputField(Question question) {
        try {
            add(QuestionTypeGui.getComponent(question.getQuestionType()), gbc);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new GuiException("Could not create input field for: " + question, e);
        }
    }
}
