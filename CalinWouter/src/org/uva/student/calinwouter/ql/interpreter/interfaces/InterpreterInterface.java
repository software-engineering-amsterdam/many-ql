package org.uva.student.calinwouter.ql.interpreter.interfaces;

import org.uva.student.calinwouter.ql.generated.node.Node;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public interface InterpreterInterface<T extends Node> {

    public Object interprete(Environment e, T node) throws InterpretationException;

}
