package edu.parser.QLS;

import edu.Widgets;
import edu.exceptions.TypeCheckException;
import edu.parser.QL.nodes.Form;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.statement.Statement;
import edu.parser.QLS.nodes.styles.Style;
import edu.parser.QLS.nodes.styles.Widget;
import edu.parser.nodes.QuestionType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 01/03/2015.
 */
public class TypeChecker implements QLSVisitor {
    public static final String UNIDENTIFIED_STYLESHEET_QUESTION = "Stylesheet contains questions that are not contained in the form. Unknown question identifiers:";
    private final List<Question> stylesheetQuestions;
    private final List<edu.parser.QL.nodes.question.Question> formQuestions;

    public TypeChecker() {
        this.stylesheetQuestions = new ArrayList<>();
        this.formQuestions = new ArrayList<>();
    }

    //todo: should accept list with (form-) Questions not a form
    public void start(Form form, Stylesheet stylesheet) {
        this.formQuestions.addAll(getQuestions(form));
        visit(stylesheet);
        confirmQuestionsExistInForm(formQuestions);
    }

    private List<edu.parser.QL.nodes.question.Question> getQuestions(Form form) { //todo: can be removed when start() does not receive form anymore
        return form.getElements()
                .stream()
                .filter(element -> element instanceof edu.parser.QL.nodes.question.Question)
                .map(statement -> (edu.parser.QL.nodes.question.Question) statement)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        visitStatements(stylesheet.getStatements());
        return stylesheet;
    }

    private void visitStatements(List<Statement> stylesheet) {
        stylesheet.stream()
                .forEach(element -> element.accept(this));
    }

    private void confirmQuestionsExistInForm(List<edu.parser.QL.nodes.question.Question> formQuestions) {
        List<Question> notFoundQuestions = stylesheetQuestions.stream()
                .filter(stylesheetQuestion ->
                        formQuestions.stream()
                                .noneMatch(doesFormQuestionsContainStylesheetQuestion(stylesheetQuestion)))
                .collect(Collectors.toList());

        if (!notFoundQuestions.isEmpty()) {
            throw new TypeCheckException(UNIDENTIFIED_STYLESHEET_QUESTION
                    + listToString(notFoundQuestions));
        }
    }

    private String listToString(List<Question> list) {
        return list
                .stream()
                .map(element -> element.getIdentifier().getIdentifier())
                .collect(Collectors.joining(", "));
    }

    private Predicate<edu.parser.QL.nodes.question.Question> doesFormQuestionsContainStylesheetQuestion(Question stylesheetQuestion) {
        return formQuestion -> stylesheetQuestion.getIdentifier().getIdentifier()
                .equals(formQuestion.getIdentifier().getIdentifier());
    }

    @Override
    public AbstractNode visit(Page page) {
        page.getSections()
                .stream()
                .forEach(section -> section.accept(this));
        return page;
    }

    @Override
    public AbstractNode visit(Question question) {
        confirmQuestionHasCompatibleType(question);
        stylesheetQuestions.add(question);
        return question;
    }

    private void confirmQuestionHasCompatibleType(Question stylesheetQuestion) {
        edu.parser.QL.nodes.question.Question formQuestion = getFormQuestion(stylesheetQuestion.getIdentifier().getIdentifier());
        List<Widgets> supportedWidgets = formQuestion.getQuestionType().getWidgets();
        boolean isWidgetTypeCompatible = isWidgetTypeCompatible(stylesheetQuestion.getStyles(), supportedWidgets);

        if (!isWidgetTypeCompatible) {
            throw new TypeCheckException("Widget type is not compatible");
        }
    }

    private edu.parser.QL.nodes.question.Question getFormQuestion(String identifier) {
        List<edu.parser.QL.nodes.question.Question> questionList = this.formQuestions.stream()
                .filter(formQuestion -> formQuestion.getIdentifier().getIdentifier().equals(identifier))
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
    public AbstractNode visit(Identifier identifier) {
        return identifier;
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
    public AbstractNode visit(Style style) {
        return style;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

}
