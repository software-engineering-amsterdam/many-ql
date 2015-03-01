package edu.gui;

import edu.gui.components.Page;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.Statement;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Steven Kok on 24/02/2015.
 */
public class MainWindow extends JFrame {

    public void initialize(Form form) {
        JPanel mainPanel = new JPanel();

        List<Question> questions = getQuestions(form.getElements());
        Page page = new Page(questions);
        Page page2 = new Page(questions.subList(0, 1));

        CardLayout cardLayout = new CardLayout(10, 10);
        mainPanel.setLayout(cardLayout);

        add(mainPanel);
        mainPanel.add(page, "1");
        mainPanel.add(page2, "2");

        setTitle("Main window");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setVisible(true);

    }

    private List<Question> getQuestions(List<Statement> elements) {
        return elements
                .stream()
                .filter(statement -> statement instanceof Question)
                .map(question -> (Question) question)
                .collect(Collectors.toList());
    }
}