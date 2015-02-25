package edu.gui;

import edu.parser.nodes.Form;
import edu.parser.nodes.question.Question;
import edu.parser.nodes.statement.Statement;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Steven Kok on 24/02/2015.
 */
public class MainWindow extends JFrame {

    public void initialize(Form form) {
        setLayout(new BorderLayout());
        setTitle("title");

        List<Question> questions = getQuestions(form.getElements());

        add(new QuestionsPane(questions));

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private List<Question> getQuestions(List<Statement> elements) {
        return elements
                .stream()
                .filter(statement -> statement instanceof Question)
                .map(question -> (Question) question)
                .collect(Collectors.toList());
    }
}