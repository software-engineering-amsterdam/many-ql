package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Radio extends AbstractWidget<Radio> {

    private String yesLbl, noLbl;
    private int arg;

    public Radio(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
    }

    public String getYesLbl() {
        return yesLbl;
    }

    public String getNoLbl() {
        return noLbl;
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseRadio(this);
    }

    @Override
    public void caseString(String string) {
        switch (arg) {
            case 0:
                yesLbl = string;
                break;
            case 1:
                noLbl = string;
                break;
            default:
                super.caseString(string);
        }
        arg++;
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseRadioWidget(question, widgetSettingsModel, this);
    }

    @Override
    public void usesBoolean() {
        return;
    }
}
