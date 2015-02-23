package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.qls.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

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
        final JPanel pagePanel = new JPanel();
        for (Section s : page.getSections()) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setBorder(BorderFactory.createTitledBorder(s.getSectionName()));
            s.apply(this);
            sectionPanel.add(lastCreatedComponent);
            pagePanel.add(sectionPanel);
        }
        page.addUpdateEventListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
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
