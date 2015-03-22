package nl.uva.softwcons.qls.validation.questionidentifier;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;

public class FormQuestionCollector implements FormVisitor<Set<Identifier>>, StatementVisitor<Set<Identifier>> {

    @Override
    public Set<Identifier> visit(ComputedQuestion statement) {
        Set<Identifier> questionIdentifier = new HashSet<Identifier>();
        questionIdentifier.add(statement.getId());
        return questionIdentifier;
    }

    @Override
    public Set<Identifier> visit(Question statement) {
        Set<Identifier> questionIdentifier = new HashSet<Identifier>();
        questionIdentifier.add(statement.getId());
        return questionIdentifier;
    }

    @Override
    public Set<Identifier> visit(Conditional statement) {
        Set<Identifier> questionsIdentifier = new HashSet<Identifier>();
        questionsIdentifier = statement.getQuestions().stream().flatMap(s -> s.accept(this).stream())
                .collect(Collectors.toSet());
        return questionsIdentifier;
    }

    @Override
    public Set<Identifier> visit(Form form) {
        Set<Identifier> questionsIdentifier = new HashSet<Identifier>();
        questionsIdentifier = form.getStatements().stream().flatMap(s -> s.accept(this).stream())
                .collect(Collectors.toSet());

        return questionsIdentifier;
    }
}
