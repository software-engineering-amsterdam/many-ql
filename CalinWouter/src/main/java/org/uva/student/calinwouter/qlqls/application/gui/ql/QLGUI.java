package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.model.*;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import javax.swing.*;
import java.awt.*;

public class QLGUI extends AbstractSwingGUI implements IQLRenderer<Component> {
    private final QLInterpreter qlIntepreter;
    private final StaticFields fieldsList;
    private final VariableTableWrapper variableTableWrapper;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (AbstractStaticFormField f : fieldsList) {
            panel.add(render(f));
        }
        return panel;
    }

    public Component render(AbstractStaticFormField formField) {
        //TODO should not catch any exception anymore
        try {
            return formField.applyRenderer(this);
        } catch (FieldNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Component render(StaticQuestionField staticQuestionField) {
        final TypeDescriptor typeDescriptor = staticQuestionField.getTypeDescriptor();
        QLWidgetFetcher qlWidgetFetcher = new QLWidgetFetcher(qlIntepreter, staticQuestionField, variableTableWrapper);
        qlWidgetFetcher.createWidget(typeDescriptor);
        return qlWidgetFetcher.getWidget().getWidgetComponent();
    }

    @Override
    public Component render(StaticComputedValueField staticComputedValueField) {
        final String identifier = staticComputedValueField.getVariable();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(identifier, variableTableWrapper);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(staticComputedValueField.getLabel(),
                    identifier,
                    null,
                    valueRepresentingLabelWidget,
                    variableTableWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public QLGUI( QLInterpreter qlIntepreter, VariableTable variableTable, StaticFields fieldsList) {
        this.qlIntepreter = qlIntepreter;
        this.fieldsList = fieldsList;
        variableTableWrapper = new VariableTableWrapper(variableTable);
    }
}
