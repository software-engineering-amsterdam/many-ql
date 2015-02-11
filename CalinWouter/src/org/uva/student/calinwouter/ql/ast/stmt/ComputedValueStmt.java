package org.uva.student.calinwouter.ql.ast.stmt;

import org.uva.student.calinwouter.ql.ast.type.Type;
import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class ComputedValueStmt extends Stmt {
    private String ident, text;
    private Type type;
    private Exp exp;

    public ComputedValueStmt(String ident, String text, Type type, Exp exp) {
        this.ident = ident;
        this.text = text;
        this.type = type;
        this.exp = exp;
    }

    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        return null; // new TForm();
    }
}
