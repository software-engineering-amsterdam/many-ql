package typeChecker;

import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Boolean;
import parser.nodes.type.Number;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public interface Visitor {

    void visit(Form form);

    void visit(IfStatement ifStatement);

    void visit(Addition addition);

    void visit(And and);

    void visit(Equal equal);

    void visit(GreaterOrEqual greaterOrEqual);

    void visit(GreaterThan greaterThan);

    void visit(Identifier identifier);

    void visit(LessOrEqual lessOrEqual);

    void visit(LessThan lessThan);

    void visit(Multiplication multiplication);

    void visit(Not not);

    void visit(NotEqual notEqual);

    void visit(Or or);

    void visit(Statement statement);

    void visit(Boolean aBoolean);

    void visit(Number number);

    void visit(QuestionType questionType);

    void visit(Label label);
}
