package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.components.Page;
import org.uva.student.calinwouter.qlqls.qls.model.components.Section;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import javax.swing.*;
import java.awt.*;

public class QLSRenderer {

    private Component render(AbstractFormField abstractFormField) {
        // TODO
        return null;
    }

    private Component render(Section section) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setBorder(BorderFactory.createTitledBorder(section.getSectionName()));
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
        for (AbstractFormField abstractFormField : section.getFields().getFields()) {
            sectionPanel.add(render(abstractFormField));
        }
        return sectionPanel;
    }

    private Component render(Page page) {
        JPanel pagePanel = new JPanel();
        for (Section section : page.getSections().getSections()) {
            pagePanel.add(render(section));
        }
        return pagePanel;
    }

    /**
     * Create a GUI for the provided stylesheet.
     */
    public void render(StyleSheet styleSheet) {
        final JFrame frame = new JFrame(styleSheet.getStyleSheetName());
        final JTabbedPane jTabbedPane = new JTabbedPane();
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (Page page : styleSheet.getPages().getPages()) {
            jTabbedPane.addTab(page.getIdent(), new JScrollPane(render(page)));
        }
        frame.getContentPane().add(jTabbedPane);
        frame.pack();
        frame.setVisible(true);
    }

}
