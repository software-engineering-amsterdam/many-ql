package typeChecker;

import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Number;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker implements Visitor {

    @Override
    public void visit(Form form) {
        form.getElements()
                .stream()
                .forEach(statement -> {
                    if (statement instanceof IfStatement) {
                        visit((IfStatement) statement);
                    } else {
                        visit(statement);
                    }
                });
    }

    @Override
    public void visit(IfStatement ifStatement) {
    }

    @Override
    public void visit(Statement statement) {
    }

    @Override
    public void visit(Addition addition) {

    }

    @Override
    public void visit(And and) {

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
