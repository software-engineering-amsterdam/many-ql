package edu.gui.components;


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

    public Page(List<Section> sections, Map<Question, List<Style>> questions) throws HeadlessException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        sections.stream()
                .forEach(section -> add(new SectionsPanel(section,questions)));
    }
}
