package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TInteger;

public class NumberExp extends Exp {
    private final TInteger number;

    @Override
    public TInteger interpret(Environment environment) throws InterpretationException {
        return number;
    }

    public NumberExp(Integer number){
        this.number = new TInteger(number);
    }
}
