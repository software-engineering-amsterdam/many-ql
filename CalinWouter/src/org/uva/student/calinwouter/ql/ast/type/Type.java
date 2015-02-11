package org.uva.student.calinwouter.ql.ast.type;

import org.uva.student.calinwouter.ql.ast.AstElement;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public abstract class Type<T extends TypeModel<?>> implements AstElement {

    public abstract Class<T> interpret(Environment environment) throws InterpretationException;

}
