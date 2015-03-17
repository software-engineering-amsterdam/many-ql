package edu.parser.QL;

import edu.nodes.QuestionType;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public interface QLVisitor {

    AbstractNode visit(Form form);

    AbstractNode visit(IfStatement ifStatement);

    AbstractNode visit(Question question);

    AbstractNode visit(Statement statement);

    AbstractNode visit(Label label);

    AbstractNode visit(ElseClause elseClause);

    AbstractNode visit(QuestionType questionType);
}
