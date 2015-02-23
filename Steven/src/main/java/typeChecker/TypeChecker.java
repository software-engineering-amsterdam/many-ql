package typeChecker;

import exceptions.TypeCheckException;
import parser.Visitor;
import parser.nodes.AbstractNode;
import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.Question;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.ElseClause;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Number;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker implements Visitor {

    public static final String ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE = "Question identifier: [%s] was already declared with type: [%s].";
    public static final String ALREADY_DECLARED_QUESTION = "Duplicate question declaration. Identifier: [%s] Type: [%s].";
    public static final String EXPRESSION_EXPECTS_BOOLEAN = "Expression expects boolean operands for type: [%s], but found: [%s]";
    public static final String EXPRESSION_EXPECTS_NON_BOOLEAN = "Expression does not expect boolean operands for type: [%s], but found: [%s]";
    private final Map<Identifier, QuestionType> questions;
    private final Set<Identifier> identifiers;

    public TypeChecker() {
        this.questions = new HashMap<>();
        this.identifiers = new HashSet<>();
    }

    @Override
    public AbstractNode visit(Form form) {
        visitStatement(form.getElements());
        checkReferenceToUndefinedQuestions();
        return form;
    }

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

    private void visitStatement(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            statements.stream()
                    .forEach(statement -> statement.accept(this));
        }
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        visitStatement(ifStatement.getStatements());
        visit(ifStatement.getExpression());
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
            return questions.put(question.getIdentifier(), question.getQuestionType());
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
                            question.getIdentifier().getIdentifier(), questions.get(question.getIdentifier()).name()));
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
        if (expression.getLeft().isConditional() && expression.getRight().isConditional()) {
            visit(expression.getLeft());
            visit(expression.getRight());
            return expression;
        } else {
            throw new TypeCheckException(String.format(EXPRESSION_EXPECTS_BOOLEAN, expression.getClass().getSimpleName(), expression.toString()));
        }
    }

    private AbstractNode visitArithmeticExpression(BinaryExpression expression) {
        if (expression.getLeft().isConditional() || expression.getRight().isConditional()) {
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
        return identifier;
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
    public AbstractNode visit(Not not) {
        if (!not.getOperand().isConditional()) {
            throw new TypeCheckException(String.format(EXPRESSION_EXPECTS_BOOLEAN, not.getClass().getSimpleName(), not.toString()));
        }
        return visit(not.getOperand());
    }

    @Override
    public AbstractNode visit(NotEqual notEqual) {
        return notEqual;
    }

    @Override
    public AbstractNode visit(parser.nodes.type.Boolean aBoolean) {
        return aBoolean;
    }

    @Override
    public AbstractNode visit(Number number) {
        return number;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

    @Override
    public AbstractNode visit(Label label) {
        return label;
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatement(elseClause.getStatements());
        return elseClause;
    }
}
