package org.uva.student.calinwouter.qlqls.qls.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

public interface IQLSRenderer<T> {

    public T render(Question question);

    public T render(ComputedValue computedValue);

}
