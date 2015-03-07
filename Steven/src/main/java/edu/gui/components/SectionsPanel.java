package edu.gui.components;


import edu.nodes.Question;
import edu.nodes.styles.Style;
import edu.parser.QLS.nodes.Section;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class SectionsPanel extends JPanel {


    public SectionsPanel(Section sections, Map<Question, List<Style>> questions) {

        QuestionsPanel questionsPanel = new QuestionsPanel(questions);
        add(questionsPanel);

    }


}
