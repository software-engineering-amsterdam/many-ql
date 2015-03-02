package edu.gui.componentsss;

import edu.exceptions.GuiException;
import edu.gui.QuestionTypeGui;
import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class QuestionsPanel extends JPanel {

    private final GridBagConstraints gbc;

    public QuestionsPanel(List<Question> questions) {
        gbc = new GridBagConstraints();
        initializeGridBagLayout();
        addQuestionsToGridBagLayout(questions);
    }

    private void initializeGridBagLayout() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
    }

    private void addQuestionsToGridBagLayout(List<Question> questions) {
        questions.stream()
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
