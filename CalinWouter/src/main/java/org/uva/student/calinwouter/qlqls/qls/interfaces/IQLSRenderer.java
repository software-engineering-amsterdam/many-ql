package org.uva.student.calinwouter.qlqls.qls.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.functions.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

public interface IQLSRenderer<T> {

    T render(Question question);

    T render(ComputedValue computedValue);

}
