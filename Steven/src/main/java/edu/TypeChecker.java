package edu;

import edu.exceptions.TypeCheckException;
import edu.parser.VisitorImpl;
import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.Form;
import edu.parser.nodes.expression.*;
import edu.parser.nodes.question.Label;
import edu.parser.nodes.question.Question;
import edu.parser.nodes.question.QuestionType;
import edu.parser.nodes.statement.ElseClause;
import edu.parser.nodes.statement.IfStatement;
import edu.parser.nodes.statement.Statement;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker extends VisitorImpl {

    public static final String ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE = "Question identifier: [%s] was already declared with type: [%s].";
    public static final String ALREADY_DECLARED_QUESTION = "Duplicate question declaration. Identifier: [%s] Type: [%s].";
    public static final String EXPRESSION_EXPECTS_BOOLEAN = "Expression expects boolean operands for type: [%s], but found: [%s]";
    public static final String EXPRESSION_EXPECTS_NON_BOOLEAN = "Expression does not expect boolean operands for type: [%s], but found: [%s]";
    private final Map<Identifier, Question> questions;
    private final Set<Identifier> identifiers;
    private static final Logger logger = Logger.getLogger(TypeChecker.class.getName());

    public TypeChecker() {
        this.questions = new HashMap<>();
        this.identifiers = new HashSet<>();
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
        return expression.accept(this);
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return statement.accept(this);
    }

    @Override
    public AbstractNode visit(Question question) {
        if (questionAlreadyFound(question)) {
            return throwExceptionForDuplicateQuestion(question);
        } else {
            return questions.put(question.getIdentifier(), question);
        }
    }

    private AbstractNode throwExceptionForDuplicateQuestion(Question question) {
        if (foundQuestionHasSameType(question)) {
            throw new TypeCheckException(
                    String.format(ALREADY_DECLARED_QUESTION,
                            question.getIdentifier().getIdentifier(), question.getQuestionType().name()));
        } else {
            throw new TypeCheckException(
                    String.format(ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE,
                            question.getIdentifier().getIdentifier(), questions.get(question.getIdentifier()).getQuestionType().name()));
        }
    }

    private boolean questionAlreadyFound(Question question) {
        return questions.containsKey(question.getIdentifier());
    }

    private boolean foundQuestionHasSameType(Question question) {
        QuestionType questionType = questions.get(question.getIdentifier()).getQuestionType();
        return questionType.equals(question.getQuestionType());
    }

    @Override
    public AbstractNode visit(Addition addition) {
        return visitArithmeticExpression(addition);
    }

    @Override
    public AbstractNode visit(And and) {
        return visitLogicalExpression(and);
    }

    @Override
    public AbstractNode visit(Or or) {
        return visitLogicalExpression(or);
    }

    private AbstractNode visitLogicalExpression(BinaryExpression expression) {
        if (expression.getLeft().hasBooleanOperands() && expression.getRight().hasBooleanOperands()) {
            visit(expression.getLeft());
            visit(expression.getRight());
            return expression;
        } else {
            throw new TypeCheckException(String.format(EXPRESSION_EXPECTS_BOOLEAN, expression.getClass().getSimpleName(), expression.toString()));
        }
    }

    private AbstractNode visitArithmeticExpression(BinaryExpression expression) {
        if (expression.getLeft().hasBooleanOperands() || expression.getRight().hasBooleanOperands()) {
            throw new TypeCheckException(String.format(EXPRESSION_EXPECTS_NON_BOOLEAN, expression.getClass().getSimpleName(), expression.toString()));
        }
        visit(expression.getLeft());
        visit(expression.getRight());
        return expression;
    }

    @Override
    public AbstractNode visit(Equal equal) {
        visit(equal.getLeft());
        visit(equal.getRight());
        return equal;
    }

    @Override
    public AbstractNode visit(GreaterOrEqual greaterOrEqual) {
        return visitArithmeticExpression(greaterOrEqual);
    }

    @Override
    public AbstractNode visit(GreaterThan greaterThan) {
        return visitArithmeticExpression(greaterThan);
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        identifiers.add(identifier); // may overwrite existing items
        checkReferenceToUndefinedQuestions();
        return identifier;
    }

    // implicitly checks for cyclic dependencies of questions
    private void checkReferenceToUndefinedQuestions() {
        String undefinedReferences = identifiers
                .stream()
                .filter(identifier -> !questions.containsKey(identifier))
                .map(Identifier::toString)
                .collect(Collectors.joining(", "));
        if (!undefinedReferences.isEmpty()) {
            throw new TypeCheckException("Invalid reference to undefined question: " + undefinedReferences);
        }
    }

    @Override
    public AbstractNode visit(LessOrEqual lessOrEqual) {
        return visitArithmeticExpression(lessOrEqual);
    }

    @Override
    public AbstractNode visit(LessThan lessThan) {
        return visitArithmeticExpression(lessThan);
    }

    @Override
    public AbstractNode visit(Multiplication multiplication) {
        return visitArithmeticExpression(multiplication);
    }

    @Override
    public AbstractNode visit(Division division) {
        return visitArithmeticExpression(division);
    }

    @Override
    public AbstractNode visit(Not not) {
        if (!not.getOperand().hasBooleanOperands()) {
            throw new TypeCheckException(String.format(EXPRESSION_EXPECTS_BOOLEAN, not.getClass().getSimpleName(), not.toString()));
        }
        return visit(not.getOperand());
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }
}
