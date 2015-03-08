package edu.gui;

import edu.gui.components.Page;
import edu.nodes.Question;
import edu.nodes.styles.Style;
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
    private int pages = 0;

    public MainWindow() {
        mainPanel = new JPanel();
        questionPanel = new JPanel();
        paginationPanel = new JPanel();
    }

    public void initialize() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        CardLayout cardLayout = new CardLayout(10, 10);
        questionPanel.setLayout(cardLayout);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(paginationPanel,BorderLayout.PAGE_END);
        add(mainPanel);
        addPaginationButtons(cardLayout);
    }

    private void addPaginationButtons(CardLayout cardLayout) {
        JButton next = new JButton("Next");
        paginationPanel.add(next);
        next.addActionListener(e -> cardLayout.show(questionPanel, "2"));
    }

    public void showMainWindow() {
        setTitle("Main window");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addPage(List<Section> sections, Map<Question, List<Style>> questions) {
        Page page = new Page(sections, questions);
        questionPanel.add(page, String.valueOf(++pages));
    }

}