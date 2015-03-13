package edu.parser.QLS;

import edu.Widgets;
import edu.exceptions.TypeCheckException;
import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.nodes.styles.Widget;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.QLSIdentifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;
import edu.parser.QLS.nodes.statement.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 01/03/2015.
 */
public class TypeChecker implements QLSVisitor {
    public static final String UNIDENTIFIED_STYLESHEET_QUESTION = "Stylesheet contains questions that are not contained in the form. Unknown question identifiers:";
    public static final String FOUND_DUPLICATE_QUESTIONS = "Found duplicate question entries in QLS for: ";
    private final List<QLSQuestion> stylesheetQuestions;
    private final List<Question> allQuestions;

    public TypeChecker() {
        this.stylesheetQuestions = new ArrayList<>();
        this.allQuestions = new ArrayList<>();
    }

    public void start(List<Question> allQuestions, Stylesheet stylesheet) {
        initializeLists();
        this.allQuestions.addAll(allQuestions);
        visit(stylesheet);
        confirmQuestionsExistInForm(this.allQuestions);
        confirmNoDuplicateQuestions(stylesheetQuestions);
    }

    private void initializeLists() {
        this.stylesheetQuestions.clear();
        this.allQuestions.clear();
    }

    private void confirmNoDuplicateQuestions(List<QLSQuestion> stylesheetQuestions) {
        List<QLSQuestion> duplicateQuestions = getDuplicateQuestions(stylesheetQuestions);
        if (!duplicateQuestions.isEmpty()) {
            String duplicateQuestionsString = ListToString(duplicateQuestions);
            throw new TypeCheckException(FOUND_DUPLICATE_QUESTIONS + duplicateQuestionsString);
        }
    }

    private List<QLSQuestion> getDuplicateQuestions(List<QLSQuestion> stylesheetQuestions) {
        return stylesheetQuestions.stream()
                .filter(a -> stylesheetQuestions.stream()
                        .filter(b -> a.getQLSIdentifier().equals(b.getQLSIdentifier())).count() > 1)
                .collect(Collectors.toList());
    }

    private String ListToString(List<QLSQuestion> duplicateQuestions) {
        return duplicateQuestions.stream()
                .map(QLSQuestion::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        stylesheet.getPages()
                .stream()
                .forEach(page -> page.accept(this));
        return stylesheet;
    }

    private void confirmQuestionsExistInForm(List<Question> questions) {
        List<QLSQuestion> notFoundQuestions = stylesheetQuestions.stream()
                .filter(stylesheetQuestion ->
                        questions.stream()
                                .noneMatch(doesFormQuestionsContainStylesheetQuestion(stylesheetQuestion)))
                .collect(Collectors.toList());

        if (!notFoundQuestions.isEmpty()) {
            throw new TypeCheckException(UNIDENTIFIED_STYLESHEET_QUESTION
                    + listToString(notFoundQuestions));
        }
    }

    private Predicate<Question> doesFormQuestionsContainStylesheetQuestion(QLSQuestion stylesheetQuestion) {
        return question -> stylesheetQuestion.getQLSIdentifier().getIdentifier()
                .equals(question.getQLIdentifier().getIdentifier());
    }

    private String listToString(List<QLSQuestion> list) {
        return list
                .stream()
                .map(element -> element.getQLSIdentifier().getIdentifier())
                .collect(Collectors.joining(", "));
    }

    @Override
    public AbstractNode visit(Page page) {
        page.getSections()
                .stream()
                .forEach(section -> section.accept(this));
        return page;
    }

    @Override
    public AbstractNode visit(QLSQuestion question) {
        confirmQuestionHasCompatibleType(question);
        stylesheetQuestions.add(question);
        return question;
    }

    private void confirmQuestionHasCompatibleType(QLSQuestion stylesheetQuestion) {
        Question formQuestion = getFormQuestion(stylesheetQuestion.getQLSIdentifier().getIdentifier());
        List<Widgets> supportedWidgets = formQuestion.getQuestionType().getWidgets();
        boolean isWidgetTypeCompatible = isWidgetTypeCompatible(stylesheetQuestion.getStyles(), supportedWidgets);

        if (!isWidgetTypeCompatible) {
            throw new TypeCheckException("Widget type is not compatible for: " + stylesheetQuestion.getQLSIdentifier());
        }
    }

    private Question getFormQuestion(String identifier) {
        List<Question> questionList = this.allQuestions.stream()
                .filter(formQuestion -> formQuestion.getQLIdentifier().getIdentifier().equals(identifier))
                .collect(Collectors.toList());

        if (questionList.isEmpty()) {
            throw new TypeCheckException("Couldn't find form question with identifier: " + identifier);
        } else if (questionList.size() > 1) {
            throw new TypeCheckException("Found duplicate form question.");
        } else {
            return questionList.get(0);
        }
    }

    private boolean isWidgetTypeCompatible(List<Style> styles, List<Widgets> supportedWidgets) {
        return styles.stream()
                .filter(style -> style instanceof Widget)
                .map(widget -> (Widget) widget)
                .allMatch(widget -> supportedWidgets.contains(widget.getWidget()));
    }

    @Override
    public AbstractNode visit(QLSIdentifier QLSIdentifier) {
        return QLSIdentifier;
    }

    @Override
    public AbstractNode visit(Section section) {
        visitQuestions(section.getQuestions());
        visitDefaultstatements(section.getDefaultStatements());
        return section;
    }

    private void visitDefaultstatements(List<Default> defaultStatements) {
        defaultStatements.stream()
                .forEach(statement -> statement.accept(this));
    }

    private void visitQuestions(List<QLSQuestion> sections) {
        sections.stream()
                .forEach(section -> section.accept(this));
    }

    @Override
    public AbstractNode visit(Default aDefault) {
        return aDefault;
    }

    @Override
    public AbstractNode visit(Style style) {
        return style;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

}
