package edu.parser.QL;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.question.QLQuestion;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class QuestionRetriever extends QLVisitorImpl {

    private final List<QLQuestion> allQuestions = new ArrayList<>();

    public List<QLQuestion> retrieveQuestions(Form form) {
        allQuestions.clear();
        visit(form);
        return allQuestions;
    }

    @Override
    public AbstractNode visit(Form form) {
        visitStatements(form.getElements());
        return form;
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        if (ifStatement.getElseClause().isPresent()) {
            visit(ifStatement.getElseClause().get());
        }
        ifStatement.getExpression().accept(this);
        visitStatements(ifStatement.getStatements());
        return ifStatement;
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }

    @Override
    public AbstractNode visit(QLQuestion question) {
        allQuestions.add(question);
        return question;
    }
}
