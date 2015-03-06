package edu.gui;

import edu.exceptions.EvaluationException;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.QuestionRetriever;
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
public class Renderer implements QLSVisitor {
    public static final String NOT_FOUND_QUESTIONS = "Not all questions are in the stylesheet.";
    private List<Question> questions;
    private final QuestionRetriever questionRetriever;
    private final MainWindow mainWindow;

    public Renderer() {
        questions = new ArrayList<>();
        questionRetriever = new QuestionRetriever();
        mainWindow = new MainWindow();
    }

    public MainWindow evaluate(List<Question> questions, Stylesheet stylesheet) {
        this.questions = questions;

        mainWindow.initialize();
        mainWindow.addPage(questions);

        return mainWindow;
    }

    private void confirmAllQuestionsAreInStylesheet(Stylesheet evaluatedStylesheet, List<Question> questions) { // todo
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
        List<Section> sections = collectSections(page);
        return new Page(sections);
    }

    private List<Section> collectSections(Page page) {
        return page.getSections()
                .stream()
                .map(section -> (Section) section.accept(this))
                .collect(Collectors.toList());
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
