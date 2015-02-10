package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.generated.node.AForm;
import org.uva.student.calinwouter.ql.generated.node.PForm;

import java.util.List;

public class Form {

    private String identifier;

    private List<QuestionStmt> statements;

    public Form(AForm aform) {
        identifier = aform.getIdent();
    }

}
