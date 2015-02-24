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

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class Evaluator extends VisitorImpl {

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
        }
        return ifStatement;
    }

    private boolean isExpressionTrue(IfStatement ifStatement) {
        return ((Boolean) ifStatement.getExpression()).isTrue();
    }

    @Override
    public AbstractNode visit(Addition addition) {
        return null;
    }

    @Override
    public AbstractNode visit(And and) {
        return null;
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
        return null;
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
        return null;
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
