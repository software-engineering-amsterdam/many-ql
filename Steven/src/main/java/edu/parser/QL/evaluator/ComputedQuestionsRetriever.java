package edu.parser.QL.evaluator;

import edu.exceptions.EvaluationException;
import edu.exceptions.TypeCheckException;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.type.Number;

import java.util.List;
import java.util.Optional;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public class ComputedQuestionsRetriever implements ExpressionVisitor<AbstractNode> {
    public static final String NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS = "Not supported operation for computed questions: ";
    private final List<Question> evaluatedQuestions;

    public ComputedQuestionsRetriever(List<Question> evaluatedQuestions) {
        this.evaluatedQuestions = evaluatedQuestions;
    }

    @Override
    public AbstractNode visit(Addition addition) {
        Number left = getNumber(addition.getLeft());
        Number right = getNumber(addition.getRight());
        return new Number(left.getNumber() + right.getNumber());
    }

    private Number getNumber(Expression expression) {
        AbstractNode abstractNode = expression.accept(this);
        if (abstractNode instanceof Number) {
            return (Number) abstractNode;
        } else {
            throw new TypeCheckException("Invalid expression: " + expression);
        }
    }

    @Override
    public AbstractNode visit(And and) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + and);
    }

    @Override
    public AbstractNode visit(Equal equal) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + equal);
    }

    @Override
    public AbstractNode visit(GreaterOrEqual greaterOrEqual) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + greaterOrEqual);
    }

    @Override
    public AbstractNode visit(GreaterThan greaterThan) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + greaterThan);
    }

    @Override
    public AbstractNode visit(QLIdentifier qlIdentifier) {
        Question question = getQuestion(qlIdentifier);
        return question.getValue();
    }

    private Question getQuestion(QLIdentifier qlIdentifier) {
        Optional<Question> question = evaluatedQuestions.stream()
                .filter(evaluatedQuestion -> evaluatedQuestion.getQLIdentifier().equals(qlIdentifier))
                .findFirst();
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new EvaluationException("There is no question with identifier: " + qlIdentifier);
        }
    }

    @Override
    public AbstractNode visit(LessOrEqual lessOrEqual) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + lessOrEqual);
    }

    @Override
    public AbstractNode visit(LessThan lessThan) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + lessThan);
    }

    @Override
    public AbstractNode visit(Multiplication multiplication) {
        Number left = getNumber(multiplication.getLeft());
        Number right = getNumber(multiplication.getRight());
        return new Number(left.getNumber() * right.getNumber());
    }

    @Override
    public AbstractNode visit(Not not) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + not);
    }

    @Override
    public AbstractNode visit(NotEqual notEqual) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + notEqual);
    }

    @Override
    public AbstractNode visit(Or or) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + or);
    }

    @Override
    public AbstractNode visit(Division division) {
        return null;
    }

    @Override
    public AbstractNode visit(edu.parser.QL.nodes.type.Boolean aBoolean) {
        throw new TypeCheckException(NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS + aBoolean);
    }

    @Override
    public AbstractNode visit(Number number) {
        return number;
    }

    @Override
    public AbstractNode visit(Expression expression) {
        return expression.accept(this);
    }
}
