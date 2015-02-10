package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class SubExp extends Exp {
    private final Exp left, right;

    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return left.interpret(e).sub(right.interpret(e));
    }

    public SubExp(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
