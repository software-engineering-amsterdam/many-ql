package edu.gui;

import edu.exceptions.GuiException;
import edu.gui.components.Page;
import edu.nodes.styles.Style;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.nodes.Section;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Kok on 24/02/2015.
 */
public class MainWindow extends JFrame {
    private final JPanel mainPanel;
    private final JPanel questionPanel;
    private final JPanel paginationPanel;
    private int totalPages = 0;
    private int currentPage = 1;
    private JButton nextButton;
    private JButton backButton;
    private final Observer questionState;

    public MainWindow(Observer questionState) {
        mainPanel = new JPanel();
        questionPanel = new JPanel();
        paginationPanel = new JPanel();
        this.questionState = questionState;
    }

    public void initialize() {
        mainPanel.setLayout(new BorderLayout());
        CardLayout cardLayout = new CardLayout(10, 10);
        questionPanel.setLayout(cardLayout);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(paginationPanel, BorderLayout.PAGE_END);
        add(mainPanel);
        addPaginationButtons(cardLayout);
    }

    private void addPaginationButtons(CardLayout cardLayout) {
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextPage(cardLayout));

        backButton = new JButton("Back");
        backButton.setVisible(false);
        backButton.addActionListener(e -> previousPage(cardLayout));

        paginationPanel.add(backButton);
        paginationPanel.add(nextButton);
    }

    private void nextPage(CardLayout cardLayout) {
        if (currentPage >= totalPages) {
            throw new GuiException(String.format("Cannot switch to next page. totalpages: [%d] currentpage: [%d]", totalPages, currentPage));
        } else {
            cardLayout.show(questionPanel, String.valueOf(++currentPage));
        }

        if (!atFirstPage()) {
            backButton.setVisible(true);
        }

        if (atLastPage()) {
            nextButton.setVisible(false);
        }
    }

    private void previousPage(CardLayout cardLayout) {
        if (currentPage <= 1) {
            throw new GuiException(String.format("Cannot switch to previous page. currentpage: [%d]", currentPage));
        } else {
            cardLayout.show(questionPanel, String.valueOf(--currentPage));
        }

        if (atFirstPage()) {
            backButton.setVisible(false);
        }

        if (!atLastPage()) {
            nextButton.setVisible(true);
        }
    }

    private boolean atLastPage() {
        return currentPage >= totalPages;
    }

    private boolean atFirstPage() {
        return currentPage <= 1;
    }

    public void showMainWindow() {
        setTitle("Main window");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addPage(List<Section> sections, Map<Question, List<Style>> questions) {
        Page page = new Page(sections, questions, questionState);
        questionPanel.add(page, String.valueOf(++totalPages));
    }

}