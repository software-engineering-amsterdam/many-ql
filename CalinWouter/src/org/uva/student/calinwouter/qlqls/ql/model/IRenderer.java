package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;

public interface IRenderer {

    public void renderQuestionField(QuestionField questionField);

    public void renderComputedValueField(ComputedValueField formField);

}
