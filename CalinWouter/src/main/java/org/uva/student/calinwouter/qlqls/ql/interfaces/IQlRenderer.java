package org.uva.student.calinwouter.qlqls.ql.interfaces;

import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

public interface IQlRenderer<T> {

    public T render(QuestionField questionField);

    public T render(ComputedValueField formField);

}
