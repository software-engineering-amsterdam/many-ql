package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQLSRenderer;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QLSGUI extends AbstractSwingGUI implements IQLSRenderer<Component> {
    private final StyleSheet styleSheet;
    private final QLInterpreter qlInterpreter;
    private final StaticFields staticFields;
    private final StateWrapper stateWrapper;

    private Component render(AbstractFormField abstractFormField) {
        return abstractFormField.applyRenderer(this);
    }

    private void renderFields(Section section, JPanel sectionPanel) {
        for (AbstractFormField abstractFormField : section.getFields()) {
            final Component renderedComponent = render(abstractFormField);
            sectionPanel.add(renderedComponent);
        }
    }

    private Component render(Section section) {
        final JPanel sectionPanel = new JPanel();
        final String sectionName = section.getSectionName();
        final TitledBorder sectionBorder = BorderFactory.createTitledBorder(sectionName);
        sectionPanel.setBorder(sectionBorder);
        BoxLayout boxLayout = new BoxLayout(sectionPanel, BoxLayout.Y_AXIS);
        sectionPanel.setLayout(boxLayout);
        renderFields(section, sectionPanel);
        return sectionPanel;
    }

    private Component render(Page page) {
        JPanel pagePanel = new JPanel();
        for (Section section : page.getSections()) {
            final Component renderedComponent = render(section);
            pagePanel.add(renderedComponent);
        }
        return pagePanel;
    }

    @Override
    public Component render(Question question) {
        final String questionIdentifier = question.getIdent();
        final TypeDescriptor typeDescriptor = staticFields.getTypeOfField(questionIdentifier);
        final FieldType fieldType = new FieldType(questionIdentifier, typeDescriptor);
        final StylingSettings stylingMap = styleSheet.getStylingSettings(fieldType);
        final AbstractWidget abstractWidget = stylingMap.getWidget();
        final QLSWidgetFetcher questionWidgetFetcher = new QLSWidgetFetcher(
                qlInterpreter, stateWrapper, questionIdentifier, stylingMap, staticFields);
        final IWidget widget = abstractWidget.createWidget(questionWidgetFetcher);
        return widget.getWidgetComponent();
    }

    @Override
    public Component render(ComputedValue computedValue) {
        final String computedValueIdentifier = computedValue.getIdent();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(computedValueIdentifier, stateWrapper);
        final String computedValueLabel = staticFields.getLabelForField(computedValueIdentifier);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueLabel,
                computedValueIdentifier, valueRepresentingLabelWidget, stateWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    @Override
    public Component renderFrameContent() {
        final JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page page : styleSheet.getPages()) {
            final String pageIdentifier = page.getIdent();
            final Component renderedPage = render(page);
            final JScrollPane renderedScrollPane = new JScrollPane(renderedPage);
            jTabbedPane.addTab(pageIdentifier, renderedScrollPane);
        }
        return jTabbedPane;
    }

    @Override
    protected String getFrameTitle() {
        return styleSheet.getStyleSheetName();
    }

    public QLSGUI(StyleSheet styleSheet, QLInterpreter qlInterpreter, VariableTable variableTable,
                  StaticFields staticFields) {
        this.qlInterpreter = qlInterpreter;
        this.staticFields = staticFields;
        this.styleSheet = styleSheet;
        this.stateWrapper = new StateWrapper(variableTable);
    }
}
