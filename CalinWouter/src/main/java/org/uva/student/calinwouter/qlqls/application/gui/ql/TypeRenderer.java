package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.CheckBoxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.TextBoxWidget;
import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;

import java.awt.*;

public class TypeRenderer extends AnalysisAdapter {
    private FormInterpreter formInterpreter;
    private FormTypeChecker formTypeChecker;
    private Component widget;
    private String identifier;

    public Component getWidget() {
        return widget;
    }

    @Override
    public void caseABoolType(ABoolType node) {
        CheckBoxWidget checkBoxWidget = new CheckBoxWidget(identifier, formInterpreter);
        widget = checkBoxWidget.getWidget();
    }

    @Override
    public void caseAIntType(AIntType node) {
        TextBoxWidget textBoxWidget = new TextBoxWidget(identifier, formInterpreter);
        widget = textBoxWidget.getWidget();
    }

    @Override
    public void caseAStringType(AStringType node) {
        TextBoxWidget textBoxWidget = new TextBoxWidget(identifier, formInterpreter);
        widget = textBoxWidget.getWidget();
    }

    public TypeRenderer(String identifier, FormInterpreter formInterpreter, FormTypeChecker formTypeChecker) {
        this.formInterpreter = formInterpreter;
        this.formTypeChecker = formTypeChecker;
        this.identifier = identifier;
    }
}
