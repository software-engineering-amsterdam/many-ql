package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.CheckBoxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.TextBoxWidget;
import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;

import java.awt.*;

public class TypeRenderer extends AnalysisAdapter {
    private HeadlessFormInterpreter headlessFormInterpreter;
    private FormTypeChecker formTypeChecker;
    private Component widget;
    private String identifier;

    public Component getWidget() {
        return widget;
    }

    @Override
    public void caseABoolType(ABoolType node) {
        CheckBoxWidget checkBoxWidget = new CheckBoxWidget(identifier, headlessFormInterpreter);
        widget = checkBoxWidget.getWidget();
    }

    @Override
    public void caseAIntType(AIntType node) {
        TextBoxWidget textBoxWidget = new TextBoxWidget(identifier, headlessFormInterpreter);
        widget = textBoxWidget.getWidget();
    }

    @Override
    public void caseAStringType(AStringType node) {
        TextBoxWidget textBoxWidget = new TextBoxWidget(identifier, headlessFormInterpreter);
        widget = textBoxWidget.getWidget();
    }

    public TypeRenderer(String identifier, HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker){
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.formTypeChecker = formTypeChecker;
        this.identifier = identifier;
    }
}
