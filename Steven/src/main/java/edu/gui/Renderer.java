package edu.gui;

import edu.exceptions.EvaluationException;
import edu.nodes.Question;
import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.QuestionRetriever;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class Renderer implements QLSVisitor {
    public static final String NOT_FOUND_QUESTIONS = "Not all questions are in the stylesheet.";
    private final QuestionRetriever questionRetriever;
    private final MainWindow mainWindow;
    private final Map<Question, List<Style>> questions;

    public Renderer() {
        questions = new HashMap<>();
        questionRetriever = new QuestionRetriever();
        mainWindow = new MainWindow();
        mainWindow.initialize();
    }

    public MainWindow render(List<Question> questions, Stylesheet stylesheet) {
        mapQuestionsAndStyles(questions, stylesheet);
        stylesheet.accept(this);
        return mainWindow;
    }

    private void mapQuestionsAndStyles(List<Question> questions, Stylesheet stylesheet) {
        List<QLSQuestion> stylesheetQuestions = extractQuestionsFromStylesheet(stylesheet);

        questions.stream()
                .forEach(question -> storeQuestions(stylesheetQuestions, question));

    }

    private List<QLSQuestion> extractQuestionsFromStylesheet(Stylesheet stylesheet) {
        return stylesheet.getStatements()
                .stream()
                .filter(statement -> statement instanceof QLSQuestion)
                .map(question -> (QLSQuestion) question)
                .collect(Collectors.toList());
    }

    private void storeQuestions(List<QLSQuestion> stylesheetQuestions, Question question) {
        List<QLSQuestion> qlsQuestions = stylesheetQuestions.stream()
                .filter(qlsQuestion -> qlsQuestion.getIdentifier().getIdentifier().equals(question.getIdentifier().getIdentifier()))
                .collect(Collectors.toList());

        if (qlsQuestions.isEmpty()) {
            this.questions.put(question, Collections.EMPTY_LIST);
        } else if (qlsQuestions.size() > 1) {
            throw new EvaluationException("Stylesheet contains duplicates.");
        } else {
            this.questions.put(question, qlsQuestions.get(0).getStyles());
        }
    }

    private void visitStatements(Stylesheet stylesheet) {
        stylesheet.getStatements()
                .stream()
                .forEach(statement -> statement.accept(this));
    }

    private void confirmAllQuestionsAreInStylesheet(Stylesheet evaluatedStylesheet, List<Question> questions) { // todo
        List<QLSQuestion> stylesheetQuestions = questionRetriever.retrieveQuestions(evaluatedStylesheet);
        if (stylesheetQuestions.size() != questions.size()) {
            throw new EvaluationException(NOT_FOUND_QUESTIONS);
        }
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        visitStatements(stylesheet);
        return stylesheet;
    }

    @Override
    public AbstractNode visit(Page page) {
        List<Section> sections = collectSections(page);
        mainWindow.addPage(sections,questions);
        return page;
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
        return section;
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
