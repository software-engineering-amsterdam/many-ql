package org.uva.student.calinwouter.qlqls.qls.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.functions.widgets.*;

public interface IQuestionWidgetCallback<T>{

    T createWidget(Checkbox checkbox);

    T createWidget(Radio radio);

    T createWidget(Spinbox spinbox);

    T createWidget(Slider slider);

    T createWidget(Textbox textbox);

    T createWidget(Combo combo);

    T createWidget(Intbox textbox);

}
