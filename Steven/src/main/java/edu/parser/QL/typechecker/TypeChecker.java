package edu.parser.QL.typechecker;

import edu.exceptions.TypeCheckException;
import edu.nodes.QuestionType;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.ExpressionVisitor;
import edu.parser.QL.nodes.expression.QLIdentifier;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker implements QLVisitor {

    public static final String ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE = "Question identifier: [%s] was already declared with type: [%s].";
    public static final String ALREADY_DECLARED_QUESTION = "Duplicate question declaration. Identifier: [%s] Type: [%s].";
    public static final String EXPRESSION_EXPECTS_BOOLEAN = "Expression expects boolean operands for type: [%s], but found: [%s]";
    public static final String EXPRESSION_EXPECTS_NON_BOOLEAN = "Expression does not expect boolean operands for type: [%s], but found: [%s]";
    private final Map<QLIdentifier, Question> questions;
    private static final Logger logger = Logger.getLogger(TypeChecker.class.getName());
    private final ExpressionVisitor expressionVisitor;

    public TypeChecker() {
        this.questions = new HashMap<>();
        expressionVisitor = new TypeCheckerExpressionValidator(questions);
    }

    @Override
    public AbstractNode visit(Form form) {
        visitStatements(form.getElements());
        checkDuplicatedQuestionLabels();
        return form;
    }

    private void checkDuplicatedQuestionLabels() {
        Set<Label> duplicatedLabels = getDuplicatedLabels();
        duplicatedLabels.forEach(
                label -> logger.warning(
                        String.format("Found duplicate name declaration for: [%s]", label.getLabel())));
    }

    private Set<Label> getDuplicatedLabels() {
        List<Label> labels = getLabels();
        return labels
                .stream()
                .filter(n -> labels.stream()
                        .filter(label -> label.equals(n))
                        .count() > 1)
                .collect(Collectors.toSet());
    }

    private List<Label> getLabels() {
        return questions.entrySet()
                .stream()
                .map(entry -> entry.getValue().getLabel())
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        visit(ifStatement.getExpression());
        visitStatements(ifStatement.getStatements());
        return ifStatement;
    }

    private AbstractNode visit(Expression expression) {
        return expressionVisitor.visit(expression);
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return statement.accept(this);
    }

    @Override
    public AbstractNode visit(Label label) {
        return label;
    }

    @Override
    public AbstractNode visit(Question question) {
        if (questionAlreadyFound(question)) {
            return throwExceptionForDuplicateQuestion(question);
        } else {
            return questions.put(question.getQLIdentifier(), question);
        }
    }

    private AbstractNode throwExceptionForDuplicateQuestion(Question question) {
        if (foundQuestionHasSameType(question)) {
            throw new TypeCheckException(
                    String.format(ALREADY_DECLARED_QUESTION,
                            question.getQLIdentifier().getIdentifier(), question.getQuestionType().name()));
        } else {
            throw new TypeCheckException(
                    String.format(ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE,
                            question.getQLIdentifier().getIdentifier(), questions.get(question.getQLIdentifier()).getQuestionType().name()));
        }
    }

    private boolean questionAlreadyFound(Question question) {
        return questions.containsKey(question.getQLIdentifier());
    }

    private boolean foundQuestionHasSameType(Question question) {
        QuestionType questionType = questions.get(question.getQLIdentifier()).getQuestionType();
        return questionType.equals(question.getQuestionType());
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

    public List<Statement> visitStatements(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            return statements.stream()
                    .map(statement -> (Statement) statement.accept(this))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
