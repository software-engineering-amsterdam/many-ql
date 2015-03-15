package edu.parser.QL;

import edu.nodes.QuestionType;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class QuestionRetriever implements QLVisitor {

    private final List<Question> allQuestions = new ArrayList<>();

    public List<Question> retrieveQuestions(Form form) {
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
        visitStatements(ifStatement.getStatements());
        return ifStatement;
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }

    @Override
    public AbstractNode visit(Question question) {
        allQuestions.add(question);
        return question;
    }


    public List<Statement> visitStatements(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            return statements.stream()
                    .map(statement -> (Statement) statement.accept(this))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return statement;
    }

    @Override
    public AbstractNode visit(Label label) {
        return label;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }
}
