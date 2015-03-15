package edu.gui;

import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import java.util.List;

/**
 * Created by Steven Kok on 15/03/2015.
 */
public class DefaultRenderer {

    private final DefaultWindow defaultWindow;

    public DefaultRenderer(Observer observer) {
        defaultWindow = new DefaultWindow(observer);
    }

    public void render(List<Question> questions) {
        defaultWindow.addQuestions(questions);
        defaultWindow.initialize();
        SwingUtilities.invokeLater(defaultWindow::showMainWindow);
    }

    public void reRender(List<Question> questions) {
        defaultWindow.addQuestions(questions);
        defaultWindow.initialize();
    }
}
