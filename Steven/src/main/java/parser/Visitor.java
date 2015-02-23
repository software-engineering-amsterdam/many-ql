package parser;

import parser.nodes.AbstractNode;
import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.Question;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.ElseClause;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Boolean;
import parser.nodes.type.Number;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public interface Visitor {

    AbstractNode visit(Form form);

    AbstractNode visit(IfStatement ifStatement);

    AbstractNode visit(Question question);

    AbstractNode visit(Addition addition);

    AbstractNode visit(And and);

    AbstractNode visit(Equal equal);

    AbstractNode visit(GreaterOrEqual greaterOrEqual);

    AbstractNode visit(GreaterThan greaterThan);

    AbstractNode visit(Identifier identifier);

    AbstractNode visit(LessOrEqual lessOrEqual);

    AbstractNode visit(LessThan lessThan);

    AbstractNode visit(Multiplication multiplication);

    AbstractNode visit(Not not);

    AbstractNode visit(NotEqual notEqual);

    AbstractNode visit(Or or);

    AbstractNode visit(Statement statement);

    AbstractNode visit(Boolean aBoolean);

    AbstractNode visit(Number number);

    AbstractNode visit(QuestionType questionType);

    AbstractNode visit(Label label);

    AbstractNode visit(ElseClause elseClause);
}
