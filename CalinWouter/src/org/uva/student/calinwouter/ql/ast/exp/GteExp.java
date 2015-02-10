package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class GteExp extends Exp {
    private Exp left, right;

    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return left.interpret(e).gte(right.interpret(e));
    }

    public GteExp(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
