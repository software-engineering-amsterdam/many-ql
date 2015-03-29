package org.uva.student.calinwouter.qlqls.ql.interfaces;

import org.uva.student.calinwouter.qlqls.ql.model.StaticComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;

public interface IQLRenderer<T> {

    T render(StaticQuestionField staticQuestionField);

    T render(StaticComputedValueField formField);

}
