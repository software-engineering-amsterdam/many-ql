package edu.gui.components;

import edu.parser.QL.nodes.question.QLQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Page extends JPanel {

    public Page(List<QLQuestion> questions) throws HeadlessException {
        add(new QuestionsPanel(questions));
    }
}
