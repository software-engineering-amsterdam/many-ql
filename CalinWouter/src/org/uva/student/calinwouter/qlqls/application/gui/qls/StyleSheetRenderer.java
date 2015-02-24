package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Page;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Section;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import javax.swing.*;
import java.awt.*;

public class StyleSheetRenderer extends AbstractRenderer {
    private Component lastCreatedComponent;
    private HeadlessFormInterpreter headlessFormInterpreter;

    public StyleSheetRenderer(HeadlessFormInterpreter headlessFormInterpreter) {
        this.headlessFormInterpreter = headlessFormInterpreter;
    }

    @Override
    public void caseStyleSheet(StyleSheet styleSheet) {
        JFrame frame = new JFrame(styleSheet.getStyleSheetName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page p : styleSheet.getPages()) {
            p.apply(this);
            System.out.println(p.getPageName());
            jTabbedPane.addTab(p.getPageName(), lastCreatedComponent);
        }
        frame.getContentPane().add(jTabbedPane);
        frame.pack();
        frame.setVisible(true);
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
        lastCreatedComponent = pagePanel;
    }

    @Override
    public void caseSection(Section section) {
        JPanel sectionPanel = new JPanel();
        for (AbstractFormField<?> f : section.getFields()) {
            FieldRenderer fieldRenderer = new FieldRenderer(headlessFormInterpreter);
            f.apply(fieldRenderer);
            sectionPanel.add(fieldRenderer.getFieldComponent());
        }
        lastCreatedComponent = sectionPanel;
    }
}
