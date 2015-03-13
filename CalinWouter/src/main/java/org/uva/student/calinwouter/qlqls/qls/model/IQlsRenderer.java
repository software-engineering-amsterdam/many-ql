package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

public interface IQlsRenderer<T> {

    public T render(Question question) throws FieldNotFoundException;

    public T render(ComputedValue computedValue);

}
