package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.interpreter.components.stmt.QuestionStmtInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.types.TypeModel;

public interface TypeDescriptor {

    void callTypeMethod(TypeCallback typeCallback);


}
