package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.*;

import java.util.HashMap;

public class IdTypeVisitor extends StatementsVisitor {
    private HashMap<String, Type> idTypes;

    public IdTypeVisitor(Form _form) {
        super(_form);
        this.idTypes = new HashMap<>();
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitQuestion(Question _question) {
        this.saveIdType(_question.getIdentifier(), _question.getType());
        return null;
    }

    @Override
    public Void visitComputedQuestion(ComputedQuestion _question) {
        this.saveIdType(_question.getIdentifier(), _question.getType());
        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveIdType(ID _id, Type _type) {
        String idName = _id.getName();
        this.idTypes.put(idName, _type);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public HashMap<String, Type> getIdTypes() {
        if (this.idTypes.keySet().isEmpty()) {
            this.visitForm();
        }
        return this.idTypes;
    }
}

