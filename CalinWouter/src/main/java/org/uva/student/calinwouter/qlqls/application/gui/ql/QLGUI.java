package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.model.*;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import javax.swing.*;
import java.awt.*;

public class QLGUI extends AbstractSwingGUI implements IQLRenderer<Component> {

    private final QLInterpreter qlIntepreter;
    private final StaticFieldsList fieldsList;
    private final VariableTable variableTable;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        JPanel panel = new JPanel();
        for (AbstractStaticFormField f : fieldsList.getFields()) {
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
        final String questionIdentifier = staticQuestionField.getVariable();
        final TypeDescriptor typeDescriptor = staticQuestionField.getTypeDescriptor();
        QLWidgetFetcher qlWidgetFetcher = new QLWidgetFetcher(qlIntepreter, staticQuestionField, this, variableTable);
        qlWidgetFetcher.createWidget(typeDescriptor);
        return qlWidgetFetcher.getWidget().getWidgetComponent();
    }

    @Override
    public Component render(StaticComputedValueField staticComputedValueField) {
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(staticComputedValueField, qlIntepreter, variableTable);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(staticComputedValueField,
                    null,
                    valueRepresentingLabelWidget,
                    qlIntepreter,
                    this);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public QLGUI( QLInterpreter qlIntepreter, VariableTable variableTable, StaticFieldsList fieldsList) {
        this.qlIntepreter = qlIntepreter;
        this.variableTable = variableTable;
        this.fieldsList = fieldsList;
    }
}
