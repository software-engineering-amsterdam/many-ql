package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.ast.AstElement;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public abstract class Exp implements AstElement {

    public abstract TypeModel<?> interpret(Environment environment) throws InterpretationException;

}
