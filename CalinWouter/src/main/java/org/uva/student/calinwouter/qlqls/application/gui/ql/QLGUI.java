package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQlRenderer;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.*;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import javax.swing.*;
import java.awt.*;

public class QLGUI extends AbstractSwingGUI implements IQlRenderer<Component> {

    private final Form form;
    private final QLIntepreter qlIntepreter;
    private final FormTypeChecker formTypeChecker;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        JPanel panel = new JPanel();
        for (FormField f : form.getFields()) {
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
        QLWidgetFetcher qlWidgetFetcher = new QLWidgetFetcher(qlIntepreter, questionField, this);
        qlWidgetFetcher.createWidget(typeDescriptor);
        return qlWidgetFetcher.getWidget().getWidgetComponent();
    }

    @Override
    public Component render(ComputedValueField computedValueField) {
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(computedValueField, qlIntepreter);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueField,
                    null,
                    valueRepresentingLabelWidget,
                    qlIntepreter,
                    this);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public QLGUI(Form form, QLIntepreter qlIntepreter, FormTypeChecker formTypeChecker) {
        this.form = form;
        this.qlIntepreter = qlIntepreter;
        this.formTypeChecker = formTypeChecker;
    }
}
