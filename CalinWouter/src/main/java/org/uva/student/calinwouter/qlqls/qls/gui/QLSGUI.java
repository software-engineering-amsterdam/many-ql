package org.uva.student.calinwouter.qlqls.qls.gui;

import org.uva.student.calinwouter.qlqls.ql.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.ql.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.qls.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
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

    }

    private Component render(Section section) {

    }

    @Override
    public Component render(Question question) {
        final String questionIdentifier = question.getIdentifier();
        final ITypeDescriptor typeDescriptor = staticFields.getTypeOfField(questionIdentifier);
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
        final String computedValueIdentifier = computedValue.getIdentifier();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(computedValueIdentifier, stateWrapper);
        final String computedValueLabel = staticFields.getLabelForField(computedValueIdentifier);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueLabel,
                computedValueIdentifier, valueRepresentingLabelWidget, stateWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    @Override
    public Component renderFrameContent() {
        return styleSheet.render();
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
