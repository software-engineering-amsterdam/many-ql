package nl.uva.softwcons.qls.ui;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.ast.type.Type;

public class QuestionTypeCollector implements FormVisitor<Void>, StatementVisitor<Void> {

    private final Map<Identifier, Type> questionsTypes;

    public QuestionTypeCollector(Form form) {
        questionsTypes = new HashMap<>();
        form.accept(this);
    }

    public Type get(Identifier questionId) {
        return questionsTypes.get(questionId);
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        questionsTypes.put(question.getId(), question.getType());
        return null;
    }

    @Override
    public Void visit(Question question) {
        questionsTypes.put(question.getId(), question.getType());
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        conditional.getQuestions().forEach(q -> q.accept(this));
        return null;
    }

    @Override
    public Void visit(Form form) {
        form.getStatements().forEach(s -> s.accept(this));
        return null;
    }

}
