package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Clean and simple QLS renderer.
 */
public class QLSRenderer {
    private static final Integer DEFAULT_WINDOW_WIDTH = 800, DEFAULT_WINDOW_HEIGHT = 600;

    /**
     * Use QL's type checker to identify the identifier's refering field. This method will throw a runtime
     * exception when the field cannot be found, which should not happen, because the program should crash
     * before the QLSRenderer takes place in case a field is not in both QL and QLS.
     */
    private static TypeDescriptor getTypeDescriptor(FormTypeChecker formTypeChecker, String ident) {
        for (Map.Entry<String, TypeDescriptor<?>> fieldToTypeMap : formTypeChecker.getFields()) {
            if (fieldToTypeMap.getKey().equals(ident)) {
                return fieldToTypeMap.getValue();
            }
        }
        throw new RuntimeException(new FieldNotFoundException());
    }

    /**
     * In case of a question, render the field by checking its type, fetching its styling settings,
     * fetching the right widget and attaching it to a label with widget - widget.
     *
     * In case of a computed value, just render a label with widget - widget with a label representing its value.
     */
    private static Component render(AbstractFormField abstractFormField, StyleSheet styleSheet,
                             HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker) throws FieldNotFoundException {
        if (abstractFormField instanceof Question) {
            Map<String, Object> stylingMap =
                    styleSheet.getStylingSettings(abstractFormField.getIdent(), getTypeDescriptor(formTypeChecker, abstractFormField.getIdent()));
            AbstractWidget abstractWidget = (AbstractWidget) stylingMap.get("widget");
            QLSWidgetFetcher questionWidgetFetcher = new QLSWidgetFetcher
                    (headlessFormInterpreter, (Question) abstractFormField, stylingMap);
            abstractWidget.applyWidget(questionWidgetFetcher);
            return questionWidgetFetcher.getWidget();
        }
        ComputedValue computedValue = (ComputedValue) abstractFormField;
        return new LabelWithWidgetWidget(computedValue, null, new LabelWidget(computedValue, headlessFormInterpreter),
                headlessFormInterpreter).getWidget();
    }

    /**
     * Render a section: create a panel with fields.
     */
    private static Component render(Section section, StyleSheet styleSheet,
                                    HeadlessFormInterpreter headlessFormInterpreter,
                                    FormTypeChecker formTypeChecker) throws FieldNotFoundException {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setBorder(BorderFactory.createTitledBorder(section.getSectionName()));
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
        for (AbstractFormField abstractFormField : section.getFields().getFields()) {
            sectionPanel.add(render(abstractFormField, styleSheet, headlessFormInterpreter, formTypeChecker));
        }
        return sectionPanel;
    }

    /**
     * Render a page: create a panel with sections.
     */
    private static Component render(Page page, StyleSheet styleSheet,
                                    HeadlessFormInterpreter headlessFormInterpreter,
                                    FormTypeChecker formTypeChecker) throws FieldNotFoundException {
        JPanel pagePanel = new JPanel();
        for (Section section : page.getSections().getSections()) {
            pagePanel.add(render(section, styleSheet, headlessFormInterpreter, formTypeChecker));
        }
        return pagePanel;
    }

    /**
     * Create a GUI for the provided stylesheet.
     */
    public static void render(StyleSheet styleSheet, HeadlessFormInterpreter headlessFormInterpreter,
                              FormTypeChecker formTypeChecker) throws FieldNotFoundException {
        final JFrame frame = new JFrame(styleSheet.getStyleSheetName());
        final JTabbedPane jTabbedPane = new JTabbedPane();
        frame.setPreferredSize(new Dimension(QLSRenderer.DEFAULT_WINDOW_WIDTH, QLSRenderer.DEFAULT_WINDOW_HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        for (Page page : styleSheet.getPages().getPages()) {
            jTabbedPane.addTab(page.getIdent(), new JScrollPane(render(page, styleSheet, headlessFormInterpreter, formTypeChecker)));
        }
        frame.getContentPane().add(jTabbedPane);
        frame.pack();
        frame.setVisible(true);
    }

}
