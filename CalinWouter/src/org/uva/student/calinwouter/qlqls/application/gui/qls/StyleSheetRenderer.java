package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.components.Page;
import org.uva.student.calinwouter.qlqls.qls.model.components.Section;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import javax.swing.*;
import java.awt.*;

public class StyleSheetRenderer extends AbstractRenderer {
    private Component lastCreatedComponent;
    private HeadlessFormInterpreter headlessFormInterpreter;
    private FormTypeChecker formTypeChecker;

    public StyleSheetRenderer(HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker) {
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.formTypeChecker = formTypeChecker;
    }

    @Override
    public void caseStyleSheet(StyleSheet styleSheet) {
        final JFrame frame = new JFrame(styleSheet.getStyleSheetName());
        frame.setPreferredSize(new Dimension(800, 600));
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page p : styleSheet.getPages()) {
            p.apply(this);
            jTabbedPane.addTab(p.getPageName(), new JScrollPane(lastCreatedComponent));
        }
        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                frame.invalidate();
            }
        });
        frame.getContentPane().add(jTabbedPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void casePage(Page page) {
        final JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new BoxLayout(pagePanel, BoxLayout.Y_AXIS));
        for (Section s : page.getSections()) {
            JPanel sectionPanel = new JPanel();

            sectionPanel.setBorder(BorderFactory.createTitledBorder(s.getSectionName()));
            s.apply(this);
            sectionPanel.add(lastCreatedComponent);
            pagePanel.add(sectionPanel);
        }
        pagePanel.add(Box.createVerticalGlue());
        lastCreatedComponent = pagePanel;
    }

    @Override
    public void caseSection(Section section) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
        for (AbstractFormField<?> f : section.getFields()) {
            FieldRenderer fieldRenderer = new FieldRenderer(headlessFormInterpreter, formTypeChecker);
            f.apply(fieldRenderer);
//            fieldRenderer.getFieldComponent().setPreferredSize(new Dimension(100, 100));
            sectionPanel.add(fieldRenderer.getFieldComponent());
        }
        lastCreatedComponent = sectionPanel;
    }
}
