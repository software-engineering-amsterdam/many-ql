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
    private CardLayout cardLayout;

    public MainWindow(Observer questionState) {
        mainPanel = new JPanel();
        questionPanel = new JPanel();
        paginationPanel = new JPanel();
        this.questionState = questionState;
        cardLayout = new CardLayout(10, 10);
    }

    public void initialize() {
        resetToDefaultState();
        mainPanel.setLayout(new BorderLayout());
        questionPanel.setLayout(cardLayout);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(paginationPanel, BorderLayout.PAGE_END);
        add(mainPanel);
        addPaginationButtons();
    }

    private void resetToDefaultState() {
        mainPanel.removeAll();
        questionPanel.removeAll();
        resetPagination();
    }

    private void resetPagination() { //todo: remember on which page
        totalPages = 0;
        paginationPanel.removeAll();
    }

    private void addPaginationButtons() {
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextPage());

        backButton = new JButton("Back");
        backButton.setVisible(false);
        backButton.addActionListener(e -> previousPage());

        paginationPanel.add(backButton);
        paginationPanel.add(nextButton);
    }

    public void nextPage() {
        goToSpecificPage(currentPage + 1);
    }

    private void previousPage() {
        goToSpecificPage(currentPage - 1);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void goToSpecificPage(int pageNumber) {
        if (isInvalidPageNumber(pageNumber)) {
            throw new GuiException(String.format("Cannot switch to page. totalpages: [%d] page: [%d]", totalPages, pageNumber));
        } else {
            jumpToPage(pageNumber);

            if (atFirstPage()) {
                backButton.setVisible(false);
            } else {
                backButton.setVisible(true);
            }

            if (atLastPage()) {
                nextButton.setVisible(false);
            } else {
                nextButton.setVisible(true);
            }
        }
    }

    private void jumpToPage(int pageNumber) {
        currentPage = pageNumber;
        cardLayout.show(questionPanel, String.valueOf(pageNumber));
    }

    private boolean isInvalidPageNumber(int pageNumber) {
        return pageNumber > totalPages || currentPage < 1;
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

    public void addPage(List<Section> sections, List<Question> questions) {
        Page page = new Page(sections, questions, questionState);
        questionPanel.add(page, String.valueOf(++totalPages));
    }

}