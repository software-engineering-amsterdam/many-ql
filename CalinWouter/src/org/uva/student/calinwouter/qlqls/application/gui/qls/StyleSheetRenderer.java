package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.qls.model.*;

import javax.swing.*;
import java.awt.*;

public class StyleSheetRenderer extends AbstractRenderer {
    private Component lastCreatedComponent;

    @Override
    public void caseStyleSheet(StyleSheet styleSheet) {
        JFrame frame = new JFrame(styleSheet.getStyleSheetName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page p : styleSheet.getPages()) {
            p.apply(this);
            jTabbedPane.add(p.getPageName(), lastCreatedComponent);
        }
        frame.getContentPane().add(lastCreatedComponent);
        frame.pack();
        frame.setVisible(true);
        styleSheet.apply(this);
    }

    @Override
    public void casePage(Page page) {
        JPanel pagePanel = new JPanel();
        for (Section s : page.getSections()) {
            s.apply(this);
            pagePanel.add(new JPanel(s.getSectionName(), lastCreatedComponent));

        }
        lastCreatedComponent = pagePanel;
    }

    @Override
    public void caseSection(Section section) {
        JPanel sectionPanel = new JPanel();
        for (AbstractFormField<?> f : section.getFields()) {
            FieldRenderer fieldRenderer = new FieldRenderer();
            f.apply(fieldRenderer);
            sectionPanel.add(fieldRenderer.getFieldComponent());
        }
        lastCreatedComponent = sectionPanel;
    }
}
