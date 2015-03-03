package org.fugazi.ql.form_data.visitor;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.*;
import org.fugazi.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionTypesVisitor implements IStatementVisitor<Void> {
    private final Form form;
    private Map<String, Type> questionTypes;

    public QuestionTypesVisitor(Form _form) {
        this.form = _form;

    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    // TODO why doesn't this.form.accept() work?
    private Void visitForm() {
        List<Statement> statementList = this.form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    public Void visitQuestion(Question question) {
        this.saveQuestionType(question.getIdentifier(), question.getType());
        return null;
    }

    public Void visitIfStatement(IfStatement ifStatement) {return null;}
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {return null;}

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestionType(ID questionId, Type questionType) {
        this.questionTypes.put(questionId.getName(), questionType);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public Map<String, Type> getQuestionTypes() {
        if (this.questionTypes == null) {
            this.questionTypes = new HashMap<>();
            // visit the form
            this.visitForm();
        }

        return this.questionTypes;
    }
}
