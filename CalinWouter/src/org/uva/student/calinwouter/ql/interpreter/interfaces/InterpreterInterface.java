package org.uva.student.calinwouter.ql.interpreter.interfaces;

import org.uva.student.calinwouter.ql.generated.node.Node;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public interface InterpreterInterface<T extends Node> {

    public void interprete(Environment e, T node);

}
