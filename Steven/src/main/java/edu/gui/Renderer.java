package edu.gui;

import edu.exceptions.EvaluationException;
import edu.exceptions.GuiException;
import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.QuestionRetriever;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class Renderer implements QLSVisitor {
    public static final String NOT_FOUND_QUESTIONS = "Not all questions are in the stylesheet.";
    private final QuestionRetriever questionRetriever;
    private final MainWindow mainWindow;
    private final List<Question> questionsToRender;
    private List<Default> globalDefaultStyles;

    public Renderer(Observer questionState) {
        questionsToRender = new ArrayList<>();
        questionRetriever = new QuestionRetriever();
        mainWindow = new MainWindow(questionState);
        globalDefaultStyles = new ArrayList<>();
    }

    public void render(List<Question> inputQuestions, Stylesheet stylesheet) {
        this.globalDefaultStyles = stylesheet.getGlobalDefaultStatements();
        initialize(inputQuestions, stylesheet);
        SwingUtilities.invokeLater(mainWindow::showMainWindow);
        mainWindow.goToSpecificPage(mainWindow.getCurrentPage());
    }

    public void reRender(List<Question> inputQuestions, Stylesheet stylesheet) {
        initialize(inputQuestions, stylesheet);
        mainWindow.goToSpecificPage(mainWindow.getCurrentPage());
    }

    private void initialize(List<Question> inputQuestions, Stylesheet stylesheet) {
        this.questionsToRender.clear();
        mainWindow.initialize();
        storeQuestionsFromStylesheet(inputQuestions, stylesheet);
        stylesheet.accept(this);
        renderRemainingQuestions(inputQuestions);
    }

    private List<Question> getRemainingQuestions(List<Question> inputQuestions) {
        return inputQuestions.stream()
                .filter(inputQuestion -> !questionsToRender.contains(inputQuestion))
                .collect(Collectors.toList());
    }

    private void renderRemainingQuestions(List<Question> inputQuestions) {
        List<Question> remainingQuestions = getRemainingQuestions(inputQuestions);
        List<QLSQuestion> convertedQuestions = convertQuestions(remainingQuestions);
        ArrayList<Section> sections = createSection(convertedQuestions);
        Page pageWithRemainingQuestions = new Page(sections);
        addPage(pageWithRemainingQuestions, remainingQuestions);
    }

    private List<QLSQuestion> convertQuestions(List<Question> remainingQuestions) {
        return remainingQuestions.stream()
                .map(remainingQuestion -> new QLSQuestion(new Identifier(remainingQuestion.getIdentifier().getIdentifier()), remainingQuestion.getStyles()))
                .collect(Collectors.toList());
    }

    private ArrayList<Section> createSection(List<QLSQuestion> convertedQuestions) {
        Section section = new Section("Other", convertedQuestions, globalDefaultStyles);
        ArrayList<Section> sections = new ArrayList<>();
        sections.add(section);
        return sections;
    }

    private void storeQuestionsFromStylesheet(List<Question> inputQuestions, Stylesheet stylesheet) {
        List<QLSQuestion> stylesheetQuestions = extractQuestionsFromStylesheet(stylesheet);

        stylesheetQuestions.stream()
                .forEach(stylesheetQuestion -> storeQuestion(stylesheetQuestion, inputQuestions));
    }

    private List<QLSQuestion> extractQuestionsFromStylesheet(Stylesheet stylesheet) {
        return questionRetriever.retrieveQuestions(stylesheet);
    }

    private void storeQuestion(QLSQuestion stylesheetQuestion, List<Question> inputQuestions) {
        List<Question> question = inputQuestions.stream()
                .filter(inputQuestion -> inputQuestion.getIdentifier().getIdentifier().equals(stylesheetQuestion.getIdentifier().getIdentifier()))
                .collect(Collectors.toList());

        if (question.size() > 1) {
            throw new EvaluationException("Stylesheet contains duplicates.");
        } else if (!question.isEmpty()) {
            storeQuestionWithStyle(question.get(0), stylesheetQuestion);
        }
    }


    private void storeQuestionWithStyle(Question inputQuestion, QLSQuestion qlsQuestion) {
        this.questionsToRender.add(cloneQuestion(inputQuestion, qlsQuestion));
    }

    private Question cloneQuestion(Question inputQuestion, QLSQuestion qlsQuestion) {
        try {
            return inputQuestion.clone(qlsQuestion.getStyles());
        } catch (CloneNotSupportedException e) {
            throw new GuiException(e);
        }
    }

    private void visitStatements(Stylesheet stylesheet) {
        stylesheet.getPages()
                .stream()
                .forEach(statement -> statement.accept(this));
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        visitStatements(stylesheet);
        return stylesheet;
    }

    @Override
    public AbstractNode visit(Page page) {
        addPage(page, questionsToRender);
        return page;
    }

    private void addPage(Page page, List<Question> questionsToRender) {
        List<Section> sections = collectSections(page);
        mainWindow.addPage(sections, questionsToRender);
    }

    private List<Section> collectSections(Page page) {
        return page.getSections()
                .stream()
                .map(section -> (Section) section.accept(this))
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visit(QLSQuestion question) {
        return question;
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractNode visit(Section section) {
        return section;
    }

    @Override
    public AbstractNode visit(Default aDefault) {
        return aDefault;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

    @Override
    public AbstractNode visit(Style style) {
        return style;
    }
}
