package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class AddExp extends Exp {
    private final Exp left, right;

    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return left.interpret(e).add(right.interpret(e));
    }

    public AddExp(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
