package edu.gui;

import edu.gui.components.Page;
import edu.parser.nodes.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Created by Steven Kok on 24/02/2015.
 */
public class MainWindow extends JFrame {
    private final JPanel mainPanel;
    private int pages = 0;

    public MainWindow() {
        mainPanel = new JPanel();
    }

    public void initialize() {
        CardLayout cardLayout = new CardLayout(10, 10);
        mainPanel.setLayout(cardLayout);
        add(mainPanel);
    }

    public void showMainWindow() {
        setTitle("Main window");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addPage(List<Question> questions) {
        Page page = new Page(questions);
        mainPanel.add(page, String.valueOf(++pages));
    }

}