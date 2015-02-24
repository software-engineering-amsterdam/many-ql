package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Slider extends AbstractWidget<Slider> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseSlider(this);
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseSliderWidget(question, widgetSettingsModel);
    }

}
