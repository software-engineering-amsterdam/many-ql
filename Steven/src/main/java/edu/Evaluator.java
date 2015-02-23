package edu;

import edu.parser.VisitorImpl;
import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.Form;
import edu.parser.nodes.expression.*;
import edu.parser.nodes.question.Label;
import edu.parser.nodes.question.QuestionType;
import edu.parser.nodes.statement.ElseClause;
import edu.parser.nodes.statement.IfStatement;
import edu.parser.nodes.statement.Statement;
import edu.parser.nodes.type.Number;

import java.util.List;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class Evaluator extends VisitorImpl {
    @Override
    public AbstractNode visit(Form form) {
        List<Statement> questions = visitStatements(form.getElements());
        return new Form(questions);
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        return null;
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
    public AbstractNode visit(NotEqual notEqual) {
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
    public AbstractNode visit(edu.parser.nodes.type.Boolean aBoolean) {
        return null;
    }

    @Override
    public AbstractNode visit(Number number) {
        return null;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return null;
    }

    @Override
    public AbstractNode visit(Label label) {
        return null;
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        return null;
    }
}
