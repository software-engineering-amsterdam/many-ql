package org.uva.student.calinwouter.qlqls.qls.model.interfaces;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.components.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Default;
import org.uva.student.calinwouter.qlqls.qls.model.components.Page;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.Radio;
import org.uva.student.calinwouter.qlqls.qls.model.components.Section;
import org.uva.student.calinwouter.qlqls.qls.model.components.Slider;
import org.uva.student.calinwouter.qlqls.qls.model.components.Spinbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;
import org.uva.student.calinwouter.qlqls.qls.model.components.Textbox;

import java.util.HashMap;

public interface IModel {

    void caseHashMap(HashMap<String, Object> hashMap);

    void caseString(String string);

    void caseInteger(Integer integer);

    void caseStyleSheet(StyleSheet styleSheet);

    void caseDefault(Default defaultSetting);

    void casePage(Page page);

    void caseSection(Section section);

    void caseTypeDescriptor(TypeDescriptor<?> typeDescriptor);

    void caseQuestion(Question question);

    void caseComputedValue(ComputedValue computedValue);

    void caseRadio(Radio radio);

    void caseSpinbox(Spinbox radio);

    void caseSlider(Slider radio);

    void caseCheckbox(Checkbox checkbox);

    void caseTextbox(Textbox checkbox);
}
