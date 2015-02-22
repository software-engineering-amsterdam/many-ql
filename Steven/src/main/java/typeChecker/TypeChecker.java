package typeChecker;

import exceptions.TypeCheckException;
import parser.Visitor;
import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.Question;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Number;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker implements Visitor {

    public static final String ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE = "Question identifier: [%s] was already declared with type: [%s].";
    public static final String ALREADY_DECLARED_QUESTION = "Duplicate question declaration. Identifier: [%s] Type: [%s].";
    private final Map<Identifier, QuestionType> questions;
    private final Set<Identifier> identifiers;

    public TypeChecker() {
        this.questions = new HashMap<>();
        this.identifiers = new HashSet<>();
    }

    @Override
    public void visit(Form form) {
        visitStatement(form.getElements());
        checkReferenceToUndefinedQuestions();
    }

    private void checkReferenceToUndefinedQuestions() {
        String undefinedReferences = identifiers
                .stream()
                .filter(identifier -> !questions.containsKey(identifier))
                .map(identifier -> identifier.toString())
                .collect(Collectors.joining(", "));
        if (!undefinedReferences.isEmpty()) {
            throw new TypeCheckException("Invalid reference to undefined question: " + undefinedReferences);
        }
    }

    private void visitStatement(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            statements.stream()
                    .forEach(statement -> statement.accept(this));
        }
    }

    @Override
    public void visit(IfStatement ifStatement) {
        visitStatement(ifStatement.getStatements());
        visit(ifStatement.getExpression());
    }

    private void visit(Expression expression) {
        expression.accept(this);
    }

    @Override
    public void visit(Statement statement) {
        statement.accept(this);
    }

    @Override
    public void visit(Question question) {
        if (questionAlreadyFound(question)) {
            if (foundQuestionHasSameType(question)) {
                throw new TypeCheckException(
                        String.format(ALREADY_DECLARED_QUESTION,
                                question.getIdentifier().getIdentifier(), question.getQuestionType().name()));
            } else {
                throw new TypeCheckException(
                        String.format(ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE,
                                question.getIdentifier().getIdentifier(), questions.get(question.getIdentifier()).name()));
            }
        } else {
            questions.put(question.getIdentifier(), question.getQuestionType());
        }
    }

    private boolean questionAlreadyFound(Question question) {
        return questions.containsKey(question.getIdentifier());
    }

    private boolean foundQuestionHasSameType(Question question) {
        QuestionType questionType = questions.get(question.getIdentifier());
        return questionType.equals(question.getQuestionType());
    }

    @Override
    public void visit(Addition addition) {

    }

    @Override
    public void visit(And and) {
        visit(and.getLeft());
        visit(and.getRight());
    }

    @Override
    public void visit(Equal equal) {

    }

    @Override
    public void visit(GreaterOrEqual greaterOrEqual) {

    }

    @Override
    public void visit(GreaterThan greaterThan) {

    }

    @Override
    public void visit(Identifier identifier) {
        identifiers.add(identifier); // may overwrite existing items
    }

    @Override
    public void visit(LessOrEqual lessOrEqual) {

    }

    @Override
    public void visit(LessThan lessThan) {

    }

    @Override
    public void visit(Multiplication multiplication) {

    }

    @Override
    public void visit(Not not) {

    }

    @Override
    public void visit(NotEqual notEqual) {

    }

    @Override
    public void visit(Or or) {

    }

    @Override
    public void visit(parser.nodes.type.Boolean aBoolean) {

    }

    @Override
    public void visit(Number number) {

    }

    @Override
    public void visit(QuestionType questionType) {

    }

    @Override
    public void visit(Label label) {

    }
}
