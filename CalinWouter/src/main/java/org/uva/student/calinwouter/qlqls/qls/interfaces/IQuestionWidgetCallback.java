package org.uva.student.calinwouter.qlqls.qls.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Combo;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.Radio;
import org.uva.student.calinwouter.qlqls.qls.model.components.Slider;

public interface IQuestionWidgetCallback {

    void caseCheckboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    void caseRadioWidget(Question question, WidgetSettingsModel widgetSettingsModel, Radio radio);

    void caseSpinboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    void caseSliderWidget(Question question, WidgetSettingsModel widgetSettingsModel, Slider slider);

    void caseTextboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    void caseComboWidget(Question question, WidgetSettingsModel widgetSettingsModel, Combo combo);
}
