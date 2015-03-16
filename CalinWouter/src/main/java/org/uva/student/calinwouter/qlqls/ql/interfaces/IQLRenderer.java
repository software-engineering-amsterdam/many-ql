package org.uva.student.calinwouter.qlqls.ql.interfaces;

import org.uva.student.calinwouter.qlqls.ql.model.StaticComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;

public interface IQLRenderer<T> {

    public T render(StaticQuestionField staticQuestionField);

    public T render(StaticComputedValueField formField);

}
