package edu;

import edu.parser.VisitorImpl;
import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.Form;
import edu.parser.nodes.expression.*;
import edu.parser.nodes.question.Question;
import edu.parser.nodes.statement.ElseClause;
import edu.parser.nodes.statement.IfStatement;
import edu.parser.nodes.statement.Statement;
import edu.parser.nodes.type.Boolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class Evaluator extends VisitorImpl {

    private final List<Statement> questions = new ArrayList<>();
    Logger logger = Logger.getLogger(Evaluator.class.getName());

    @Override
    public AbstractNode visit(Form form) {
        visitStatements(form.getElements());
        return new Form(questions);
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        if (isExpressionTrue(ifStatement)) {
            visitStatements(ifStatement.getStatements());
        }
        return ifStatement;
    }

    private boolean isExpressionTrue(IfStatement ifStatement) {
        return ((Boolean) ifStatement.getExpression().accept(this)).isTrue();
    }

    @Override
    public AbstractNode visit(Addition addition) {
        return null;
    }

    @Override
    public AbstractNode visit(And and) {
        Boolean left = (Boolean) and.getLeft().accept(this);
        Boolean right = (Boolean) and.getRight().accept(this);
        return new Boolean(left.isTrue() && right.isTrue());
    }


    @Override
    public AbstractNode visit(Equal equal) {
        return null;
    }

    @Override
    public AbstractNode visit(GreaterOrEqual greaterOrEqual) {
        return null;
    }

    @Override
    public AbstractNode visit(GreaterThan greaterThan) {
        return null;
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        Optional<Question> foundQuestion = getQuestion(identifier);

        if (foundQuestion.isPresent()) {
            return new Boolean(foundQuestion.get().isEnabled());
        } else {
            logger.warning("Reference to undefined question: " + identifier);
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
        return null;
    }

    @Override
    public AbstractNode visit(LessThan lessThan) {
        return null;
    }

    @Override
    public AbstractNode visit(Multiplication multiplication) {
        return null;
    }

    @Override
    public AbstractNode visit(Not not) {
        return null;
    }

    @Override
    public AbstractNode visit(Or or) {
        Boolean left = (Boolean) or.getLeft().accept(this);
        Boolean right = (Boolean) or.getRight().accept(this);
        return new Boolean(left.isTrue() || right.isTrue());
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return null;
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        return null;
    }

    @Override
    public AbstractNode visit(Question question) {
        if (question.isEnabled()) {
            questions.add(question);
        }
        return super.visit(question);
    }

}
