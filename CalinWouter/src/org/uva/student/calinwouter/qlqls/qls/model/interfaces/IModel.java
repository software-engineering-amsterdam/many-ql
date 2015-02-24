package org.uva.student.calinwouter.qlqls.qls.model.interfaces;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.functions.*;

import java.util.HashMap;

public interface IModel {

    void caseHashMap(HashMap<Object, Object> hashMap);

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

}
