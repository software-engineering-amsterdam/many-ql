package edu.gui.components;


import edu.gui.Observer;
import edu.nodes.Question;
import edu.nodes.styles.Style;
import edu.parser.QLS.nodes.Section;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Page extends JPanel {

    public Page(List<Section> sections, Map<Question, List<Style>> questions, Observer questionState) throws HeadlessException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        sections.stream()
                .forEach(section -> addSectionsPanel(questions, section, questionState));
    }

    private void addSectionsPanel(Map<Question, List<Style>> questions, Section section, Observer questionState) {
        add(createSectionPanel(questions, section, questionState));
        add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private SectionsPanel createSectionPanel(Map<Question, List<Style>> questions, Section section, Observer questionState) {
        SectionsPanel sectionsPanel = new SectionsPanel(section, questions, questionState);
        sectionsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(section.getTitle()), BorderFactory.createEmptyBorder()));

        return sectionsPanel;
    }
}
