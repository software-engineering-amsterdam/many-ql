package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.ast.stmt.QuestionStmt;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.util.List;

public class Form implements AstElement {

    private String identifier;

    private List<QuestionStmt> statements;

    public Form(String identifier, List<QuestionStmt> statements) {
        this.identifier = identifier;
        this.statements = statements;
    }

    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
