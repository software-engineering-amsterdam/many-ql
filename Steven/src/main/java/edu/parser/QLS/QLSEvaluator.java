package edu.parser.QLS;

import edu.exceptions.EvaluationException;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;
import edu.parser.QLS.nodes.statement.Statement;
import edu.parser.nodes.Question;
import edu.parser.nodes.QuestionType;
import edu.parser.nodes.styles.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class QLSEvaluator implements QLSVisitor {
    public static final String NOT_FOUND_QUESTIONS = "Not all questions are in the stylesheet.";
    private List<Question> questions;
    private final QuestionRetriever questionRetriever;

    public QLSEvaluator() {
        questions = new ArrayList<>();
        questionRetriever = new QuestionRetriever();
    }

    public Stylesheet evaluate(List<Question> questions, Stylesheet stylesheet) {
        this.questions.clear();
        this.questions = questions;
        Stylesheet evaluatedStylesheet = (Stylesheet) visit(stylesheet);
        confirmAllQuestionsAreInStylesheet(evaluatedStylesheet, questions);
        return evaluatedStylesheet;
    }

    private void confirmAllQuestionsAreInStylesheet(Stylesheet evaluatedStylesheet, List<Question> questions) {
        List<QLSQuestion> stylesheetQuestions = questionRetriever.retrieveQuestions(evaluatedStylesheet);
        if (stylesheetQuestions.size() != questions.size()) {
            throw new EvaluationException(NOT_FOUND_QUESTIONS);
        }
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        return new Stylesheet(stylesheet.getTitle(), collectStatements(stylesheet));
    }

    private List<Statement> collectStatements(Stylesheet stylesheet) {
        return stylesheet.getStatements()
                .stream()
                .map(statement -> (Statement) statement.accept(this))
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visit(Page page) {
        return null;
    }

    @Override
    public AbstractNode visit(QLSQuestion question) {
        return null;
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        return null;
    }

    @Override
    public AbstractNode visit(Section section) {
        return null;
    }

    @Override
    public AbstractNode visit(Default aDefault) {
        return null;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return null;
    }

    @Override
    public AbstractNode visit(Style style) {
        return null;
    }
}
