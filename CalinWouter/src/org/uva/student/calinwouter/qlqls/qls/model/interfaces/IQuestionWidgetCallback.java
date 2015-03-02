package org.uva.student.calinwouter.qlqls.qls.model.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

public interface IQuestionWidgetCallback {

    public void caseCheckboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    public void caseComboboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    public void caseRadioWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    public void caseSpinboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    public void caseSliderWidget(Question question, WidgetSettingsModel widgetSettingsModel);

    public void caseTextboxWidget(Question question, WidgetSettingsModel widgetSettingsModel);

}
