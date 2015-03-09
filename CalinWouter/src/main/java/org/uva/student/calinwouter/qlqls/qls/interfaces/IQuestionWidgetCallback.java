package org.uva.student.calinwouter.qlqls.qls.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.components.*;

public interface IQuestionWidgetCallback {

    void widgetIsCheckboxWidget(Checkbox checkbox);

    void widgetIsRadioWidget(Radio radio);

    void widgetIsSpinboxWidget(Spinbox spinbox);

    void widgetIsSliderWidget(Slider slider);

    void widgetIsTextboxWidget(Textbox textbox);

    void widgetIsComboWidget(Combo combo);

    void widgetIsIntboxWidget(Textbox textbox);
}
