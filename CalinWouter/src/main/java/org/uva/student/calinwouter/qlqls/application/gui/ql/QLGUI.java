package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQlRenderer;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.*;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import javax.swing.*;
import java.awt.*;

public class QLGUI extends AbstractSwingGUI implements IQlRenderer<Component> {

    private final QLIntepreter qlIntepreter;
    private final FormTypeChecker formTypeChecker;
    private final SymbolTable symbolTable;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        JPanel panel = new JPanel();
        for (FormField f : qlIntepreter.getForm().getFields()) {
            panel.add(render(f));
        }
        return panel;
    }

    public Component render(FormField formField) {
        try {
            return formField.applyRenderer(this);
        } catch (FieldNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Component render(QuestionField questionField) {
        final String questionIdentifier = questionField.getVariable();
        final TypeDescriptor typeDescriptor = formTypeChecker.getTypeDescriptor(questionIdentifier);
        QLWidgetFetcher qlWidgetFetcher = new QLWidgetFetcher(qlIntepreter, questionField, this, symbolTable);
        qlWidgetFetcher.createWidget(typeDescriptor);
        return qlWidgetFetcher.getWidget().getWidgetComponent();
    }

    @Override
    public Component render(ComputedValueField computedValueField) {
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(computedValueField, qlIntepreter, symbolTable);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueField,
                    null,
                    valueRepresentingLabelWidget,
                    qlIntepreter,
                    this);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public QLGUI( QLIntepreter qlIntepreter, SymbolTable symbolTable, Form form, FormTypeChecker formTypeChecker) {
        this.qlIntepreter = qlIntepreter;
        this.formTypeChecker = formTypeChecker;
        this.symbolTable = symbolTable;
    }
}
