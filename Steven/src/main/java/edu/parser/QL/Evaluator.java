package edu.parser.QL;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;
import edu.parser.QL.nodes.type.Boolean;
import edu.parser.QL.nodes.type.Number;
import edu.parser.QL.nodes.expression.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class Evaluator extends QLVisitorImpl { //todo: should only return list with questions, not a form

    private final List<Statement> questions = new ArrayList<>();

    @Override
    public AbstractNode visit(Form form) {
        visitStatements(form.getElements());
        return new Form(questions);
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        if (isExpressionTrue(ifStatement)) {
            visitStatements(ifStatement.getStatements());
        } else {
            if (ifStatement.getElseClause().isPresent())
                visitStatements(ifStatement.getElseClause().get().getStatements());
        }
        return ifStatement;
    }

    private boolean isExpressionTrue(IfStatement ifStatement) {
        return ((Boolean) ifStatement.getExpression().accept(this)).isTrue();
    }

    @Override
    public AbstractNode visit(Addition addition) {
        Number left = (Number) addition.getLeft().accept(this);
        Number right = (Number) addition.getRight().accept(this);
        return new Number(left.getValue() + right.getValue());
    }

    @Override
    public AbstractNode visit(And and) {
        Boolean left = (Boolean) and.getLeft().accept(this);
        Boolean right = (Boolean) and.getRight().accept(this);
        return new Boolean(left.isTrue() && right.isTrue());
    }


    @Override
    public AbstractNode visit(Equal equal) {
        Number left = (Number) equal.getLeft().accept(this);
        Number right = (Number) equal.getRight().accept(this);
        return new Boolean(left.getValue() == right.getValue());
    }

    @Override
    public AbstractNode visit(GreaterOrEqual greaterOrEqual) {
        Number left = (Number) greaterOrEqual.getLeft().accept(this);
        Number right = (Number) greaterOrEqual.getRight().accept(this);
        return new Boolean(left.getValue() >= right.getValue());
    }

    @Override
    public AbstractNode visit(GreaterThan greaterThan) {
        Number left = (Number) greaterThan.getLeft().accept(this);
        Number right = (Number) greaterThan.getRight().accept(this);
        return new Boolean(left.getValue() > right.getValue());
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        Optional<Question> foundQuestion = getQuestion(identifier);

        if (foundQuestion.isPresent()) {
            return new Boolean(foundQuestion.get().isEnabled());
        } else {
            return new Boolean(false); // if question does not exist, expression cannot be true.
        }
    }

    private Optional<Question> getQuestion(Identifier identifier) {
        return questions
                .stream()
                .map(question -> (Question) question)
                .filter(q -> q.getIdentifier().equals(identifier))
                .findFirst();
    }

    @Override
    public AbstractNode visit(LessOrEqual lessOrEqual) {
        Number left = (Number) lessOrEqual.getLeft().accept(this);
        Number right = (Number) lessOrEqual.getRight().accept(this);
        return new Boolean(left.getValue() <= right.getValue());
    }

    @Override
    public AbstractNode visit(LessThan lessThan) {
        Number left = (Number) lessThan.getLeft().accept(this);
        Number right = (Number) lessThan.getRight().accept(this);
        return new Boolean(left.getValue() < right.getValue());
    }

    @Override
    public AbstractNode visit(Multiplication multiplication) {
        Number left = (Number) multiplication.getLeft().accept(this);
        Number right = (Number) multiplication.getRight().accept(this);
        return new Number(left.getValue() * right.getValue());
    }

    @Override
    public AbstractNode visit(Not not) {
        Boolean result = (Boolean) not.getOperand().accept(this);
        return new Boolean(!result.isTrue());
    }

    @Override
    public AbstractNode visit(Or or) {
        Boolean left = (Boolean) or.getLeft().accept(this);
        Boolean right = (Boolean) or.getRight().accept(this);
        return new Boolean(left.isTrue() || right.isTrue());
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }

    @Override
    public AbstractNode visit(Question question) {
        questions.add(question);
        return super.visit(question);
    }

    @Override
    public AbstractNode visit(Division division) {
        Number left = (Number) division.getLeft().accept(this);
        Number right = (Number) division.getRight().accept(this);
        if (left.getValue() == 0 || right.getValue() == 0) {
            throw new ArithmeticException("Cannot divide by 0 for:" + division);
        }
        return new Number(left.getValue() / right.getValue());
    }

    @Override
    public AbstractNode visit(NotEqual notEqual) {
        Number left = (Number) notEqual.getLeft().accept(this);
        Number right = (Number) notEqual.getRight().accept(this);
        return new Boolean(left.getValue() != right.getValue());
    }
}
