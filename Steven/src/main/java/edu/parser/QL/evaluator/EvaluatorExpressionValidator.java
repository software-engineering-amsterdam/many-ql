package edu.parser.QL.evaluator;

import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.type.Boolean;
import edu.parser.QL.nodes.type.Number;

import java.util.List;
import java.util.Optional;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public class EvaluatorExpressionValidator implements ExpressionVisitor<Expression> {
    private final List<Question> evaluatedQuestions;

    public EvaluatorExpressionValidator(List<Question> evaluatedQuestions) {
        this.evaluatedQuestions = evaluatedQuestions;
    }

    @Override
    public Expression visit(Addition addition) {
        Number left = (Number) addition.getLeft().accept(this);
        Number right = (Number) addition.getRight().accept(this);
        return new Number(left.getNumber() + right.getNumber());
    }

    @Override
    public Expression visit(And and) {
        Boolean left = (Boolean) and.getLeft().accept(this);
        Boolean right = (Boolean) and.getRight().accept(this);
        return new Boolean(left.isTrue() && right.isTrue());
    }

    @Override
    public Expression visit(Equal equal) {
        Number left = (Number) equal.getLeft().accept(this);
        Number right = (Number) equal.getRight().accept(this);
        return new Boolean(left.getNumber() == right.getNumber());
    }

    @Override
    public Expression visit(GreaterOrEqual greaterOrEqual) {
        Number left = (Number) greaterOrEqual.getLeft().accept(this);
        Number right = (Number) greaterOrEqual.getRight().accept(this);
        return new Boolean(left.getNumber() >= right.getNumber());
    }

    @Override
    public Expression visit(GreaterThan greaterThan) {
        Number left = (Number) greaterThan.getLeft().accept(this);
        Number right = (Number) greaterThan.getRight().accept(this);
        return new Boolean(left.getNumber() > right.getNumber());
    }


    @Override
    public Expression visit(LessOrEqual lessOrEqual) {
        Number left = (Number) lessOrEqual.getLeft().accept(this);
        Number right = (Number) lessOrEqual.getRight().accept(this);
        return new Boolean(left.getNumber() <= right.getNumber());
    }

    @Override
    public Expression visit(LessThan lessThan) {
        Number left = (Number) lessThan.getLeft().accept(this);
        Number right = (Number) lessThan.getRight().accept(this);
        return new Boolean(left.getNumber() < right.getNumber());
    }

    @Override
    public Expression visit(Multiplication multiplication) {
        Number left = (Number) multiplication.getLeft().accept(this);
        Number right = (Number) multiplication.getRight().accept(this);
        return new Number(left.getNumber() * right.getNumber());
    }

    @Override
    public Expression visit(Not not) {
        Boolean result = (Boolean) not.getOperand().accept(this);
        return new Boolean(!result.isTrue());
    }

    @Override
    public Expression visit(Or or) {
        Boolean left = (Boolean) or.getLeft().accept(this);
        Boolean right = (Boolean) or.getRight().accept(this);
        return new Boolean(left.isTrue() || right.isTrue());
    }

    @Override
    public Expression visit(Division division) {
        Number left = (Number) division.getLeft().accept(this);
        Number right = (Number) division.getRight().accept(this);
        if (left.getNumber() == 0 || right.getNumber() == 0) {
            throw new ArithmeticException("Cannot divide by 0 for:" + division);
        }
        return new Number(left.getNumber() / right.getNumber());
    }

    @Override
    public Expression visit(Boolean aBoolean) {
        return aBoolean;
    }

    @Override
    public Expression visit(Number number) {
        return number;
    }

    @Override
    public Expression visit(Expression expression) {
        return (Expression) expression.accept(this);
    }

    @Override
    public Expression visit(NotEqual notEqual) {
        Number left = (Number) notEqual.getLeft().accept(this);
        Number right = (Number) notEqual.getRight().accept(this);
        return new Boolean(left.getNumber() != right.getNumber());
    }

    @Override
    public Expression visit(QLIdentifier qlIdentifier) {
        Optional<Question> foundQuestion = getQuestion(qlIdentifier);
        if (foundQuestion.isPresent()) {
            return new Boolean(isQuestionEnabled(foundQuestion.get()));
        } else {
            return new Boolean(false); // if question does not exist, expression cannot be true.
        }
    }

    private boolean isQuestionEnabled(Question foundQuestion) {
        return foundQuestion.isEnabled();
    }

    private Optional<Question> getQuestion(QLIdentifier QLIdentifier) {
        return evaluatedQuestions
                .stream()
                .filter(q -> q.getQLIdentifier().equals(QLIdentifier))
                .findFirst();
    }
}
