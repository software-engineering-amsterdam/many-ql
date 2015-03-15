package edu.gui;

import edu.gui.components.QuestionsPanel;
import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Steven Kok on 24/02/2015.
 */
public class DefaultWindow {
    private final JFrame mainFrame;
    private final JPanel mainPanel;
    private final Observer questionState;
    private QuestionsPanel questionsPanel;

    public DefaultWindow(Observer questionState) {
        mainPanel = new JPanel();
        this.questionState = questionState;
        mainFrame = new JFrame();
    }

    public void initialize() {
        resetToDefaultState();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(questionsPanel, BorderLayout.CENTER);
        mainFrame.add(mainPanel);
    }

    private void resetToDefaultState() {
        mainPanel.removeAll();
        mainPanel.removeAll();
    }

    public void showMainWindow() {
        mainFrame.setTitle("Main window");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void addQuestions(List<Question> questions) {
        questionsPanel = new QuestionsPanel(questions, questionState);
    }

}