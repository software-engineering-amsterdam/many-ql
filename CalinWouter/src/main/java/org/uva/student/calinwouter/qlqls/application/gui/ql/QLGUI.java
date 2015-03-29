package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.model.*;

import javax.swing.*;
import java.awt.*;

public class QLGUI extends AbstractSwingGUI implements IQLRenderer<Component> {
    private final QLInterpreter qlInterpreter;
    private final StaticFields fieldsList;
    private final StateWrapper stateWrapper;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (AbstractStaticFormField f : fieldsList) {
            panel.add(render(f));
        }
        return panel;
    }

    public Component render(AbstractStaticFormField formField) {
        return formField.applyRenderer(this);
    }

    @Override
    public Component render(StaticQuestionField staticQuestionField) {
        final ITypeDescriptor typeDescriptor = staticQuestionField.getTypeDescriptor();
        final QLWidgetFetcher qlWidgetFetcher = new QLWidgetFetcher(qlInterpreter, staticQuestionField, stateWrapper);
        qlWidgetFetcher.createWidget(typeDescriptor);
        return qlWidgetFetcher.getWidget().getWidgetComponent();
    }

    @Override
    public Component render(StaticComputedValueField staticComputedValueField) {
        final String identifier = staticComputedValueField.getVariable();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(identifier, stateWrapper);
        final LabelWithWidgetWidget labelWithWidgetWidget;
        final String fieldLabel = staticComputedValueField.getLabel();
        labelWithWidgetWidget = new LabelWithWidgetWidget(
                fieldLabel, identifier, valueRepresentingLabelWidget, stateWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public QLGUI(QLInterpreter qlInterpreter, VariableTable variableTable, StaticFields fieldsList) {
        this.qlInterpreter = qlInterpreter;
        this.fieldsList = fieldsList;
        stateWrapper = new StateWrapper(variableTable);
    }
}
