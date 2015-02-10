package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class NumberExp extends Exp{
    private Integer number;

    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        return number;
    }

    public NumberExp(Integer number){
        this.number = number;
    }
}
