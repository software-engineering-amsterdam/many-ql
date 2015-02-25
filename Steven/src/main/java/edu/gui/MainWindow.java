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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class QuestionsPane extends JPanel {


    public QuestionsPane(List<Question> questions) {
        GridBagConstraints gbc = initializeGridBagLayout();
        addQuestionsToGridBagLayout(questions, gbc);
    }

    private void addQuestionsToGridBagLayout(List<Question> questions, GridBagConstraints gbc) {
        questions
                .stream()
                .forEachOrdered(question -> addQuestionToGridBagLayout(question, gbc));
    }

    private void addQuestionToGridBagLayout(Question question, GridBagConstraints gbc) {
        gbc.gridx = 0;

        String label = question.getLabel().getLabel();
        add(new JLabel(label), gbc);
        gbc.gridx++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField(10), gbc);

        gbc.gridy++;
    }

    private GridBagConstraints initializeGridBagLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        return gbc;
    }

}