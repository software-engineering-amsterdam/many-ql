package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Slider extends AbstractWidget<Slider> {
    private int arg;
    private int min, max;

    public Slider(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseSlider(this);
    }

    @Override
    public void caseInteger(Integer i) {
        switch (arg) {
            case 0:
                min = i;
                break;
            case 1:
                max = i;
                break;
            default:
                super.caseInteger(i);
                break;
        }
        arg++;
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseSliderWidget(question, widgetSettingsModel, this);
    }

    @Override
    public void usesInteger() {
        return;
    }

}
