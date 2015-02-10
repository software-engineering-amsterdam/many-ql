package org.uva.student.calinwouter.ql.ast.stmt;

import org.uva.student.calinwouter.ql.ast.AstElement;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public abstract class Stmt implements AstElement {

    public abstract Object interpret(Environment environment) throws InterpretationException;

}
