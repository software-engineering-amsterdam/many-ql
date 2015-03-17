package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.IQlsRenderer;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class QLSGUI extends AbstractSwingGUI implements IQlsRenderer<Component> {
    private final StyleSheet styleSheet;
    private final QLInterpreter qlIntepreter;
    private final StaticFields staticFields;
    private final VariableTableWrapper variableTableWrapper;

    /**
     * In case of a question, render the field by checking its type, fetching its styling settings,
     * fetching the right widget and attaching it to a label with widget - widget.
     *
     * In case of a computed value, just render a label with widget - widget with a label representing its value.
     */
    private Component render(AbstractFormField abstractFormField) {
        try {
            return abstractFormField.applyRenderer(this);
        } catch(FieldNotFoundException e) {
            // This exception should never be thrown, assuming the type checker did its work correctly. - TODO: then this try-catch should be removed
            throw new RuntimeException(e);
        }
    }

    /**
     * Render a section: create a panel with fields.
     */
    private Component render(Section section) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setBorder(BorderFactory.createTitledBorder(section.getSectionName()));
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
        for (AbstractFormField abstractFormField : section.getFields().getFields()) {
            sectionPanel.add(render(abstractFormField));
        }
        return sectionPanel;
    }

    /**
     * Render a page: create a panel with sections.
     */
    private Component render(Page page) {
        JPanel pagePanel = new JPanel();
        for (Section section : page.getSections().getSections()) {
            pagePanel.add(render(section));
        }
        return pagePanel;
    }

    /*
     * Render a question field. Use the type descriptor to fetch the right styling settings and afterwards widget.
     */
    @Override
    public Component render(Question question) {
        try {
            final String questionIdentifier = question.getIdent();
            final TypeDescriptor typeDescriptor = staticFields.getTypeOfField(questionIdentifier);
            final StylingSettings stylingMap = styleSheet.getStylingSettings(questionIdentifier, typeDescriptor);
            final AbstractWidget abstractWidget = stylingMap.getWidget();
            final QLSWidgetFetcher questionWidgetFetcher = new QLSWidgetFetcher(qlIntepreter, variableTableWrapper, questionIdentifier, stylingMap, staticFields);
            final IWidget widget = abstractWidget.createWidget(questionWidgetFetcher);
            return widget.getWidgetComponent();
        } catch(FieldNotFoundException e) {
            // This exception should never be thrown, assuming the type checker did its work correctly.
            throw new RuntimeException(e);
        }
    }

    /**
     * Render a computed value field.
     */
    @Override
    public Component render(ComputedValue computedValue) {
        final String computedValueIdentifier = computedValue.getIdent();
        final TypeDescriptor typeless = null;
        final HashMap<String, Object> emptyStylingSettingsMap = new HashMap<String, Object>();
        final StylingSettings stylingSettingsObject = new StylingSettings(typeless, emptyStylingSettingsMap);
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(computedValueIdentifier, variableTableWrapper);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(
                staticFields.getLabelForField(computedValueIdentifier),
                computedValueIdentifier,
                stylingSettingsObject,
                valueRepresentingLabelWidget,
                variableTableWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    @Override
    public Component renderFrameContent() {
        final JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page page : styleSheet.getPages().getPages()) {
            jTabbedPane.addTab(page.getIdent(), new JScrollPane(render(page)));
        }
        return jTabbedPane;
    }

    @Override
    protected String getFrameTitle() {
        return styleSheet.getStyleSheetName();
    }

    public QLSGUI(StyleSheet styleSheet, QLInterpreter qlIntepreter, VariableTable variableTable,
                  StaticFields staticFields) {
        this.qlIntepreter = qlIntepreter;
        this.staticFields = staticFields;
        this.styleSheet = styleSheet;
        this.variableTableWrapper = new VariableTableWrapper(variableTable);
    }
}
