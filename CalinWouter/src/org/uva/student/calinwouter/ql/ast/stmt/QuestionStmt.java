package org.uva.student.calinwouter.ql.ast.stmt;

import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.ast.type.Type;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.QuestionDisplayModel;
import org.uva.student.calinwouter.ql.interpreter.model.types.TFormQuestionElement;

public class QuestionStmt extends Stmt {
    private String variable;
    private String text;
    private Type type;

    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        //environment.getDisplayModels().add(new TFormQuestionElement(variable, text, type, environment));
        return null;
    }

    public QuestionStmt(String variable, String text, Type type) {
        this.variable = variable;
        this.text = text;
        this.type = type;
    }
}
