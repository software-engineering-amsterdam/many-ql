package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.ComputedValueWidgetFetcher;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.QuestionWidgetFetcher;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.functions.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import java.awt.*;

public class FieldRenderer extends AbstractRenderer {
    private Component fieldComponent;
    private HeadlessFormInterpreter headlessFormInterpreter;
    private FormTypeChecker formTypeChecker;

    @Override
    public void caseQuestion(Question question) {
        QuestionWidgetFetcher w = new QuestionWidgetFetcher(headlessFormInterpreter);
        try {
            question.applyWidget(w, formTypeChecker.getTypeDescriptor(question.getFieldName()));
        } catch(NullPointerException e) {
            // This should only occur when the field is used in QLS and not in QL.
            // Checking that there are no references to question
            System.out.println("Not defined: " + question.getFieldName() + ", " + headlessFormInterpreter.getField(question.getFieldName()));
            this.fieldComponent = new JPanel();
            return;
        }
        this.fieldComponent = w.getWidget();
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        ComputedValueWidgetFetcher c = new ComputedValueWidgetFetcher(headlessFormInterpreter);
        computedValue.applyWidget(c);
        this.fieldComponent = c.getWidget();
    }

    public Component getFieldComponent() {
        return fieldComponent;
    }

    public FieldRenderer(HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker) {
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.formTypeChecker = formTypeChecker;
    }
}
