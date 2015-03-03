package edu.parser.QLS;

import edu.exceptions.TypeCheckException;
import edu.parser.QL.nodes.Form;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.styles.Color;
import edu.parser.QLS.nodes.styles.Font;
import edu.parser.QLS.nodes.styles.Widget;
import edu.parser.QLS.nodes.styles.Width;
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

    public TypeChecker(Form form) {
        this.formQuestions = getQuestions(form);
        this.stylesheetQuestions = new ArrayList<>();
    }

    private List<edu.parser.QL.nodes.question.Question> getQuestions(Form form) {
        return form.getElements()
                .stream()
                .filter(element -> element instanceof edu.parser.QL.nodes.question.Question)
                .map(statement -> (edu.parser.QL.nodes.question.Question) statement)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        visitStatements(stylesheet);
        confirmQuestionsExistInForm(formQuestions);
        return stylesheet;
    }

    private void visitStatements(Stylesheet stylesheet) {
        stylesheet.getStatements()
                .stream()
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
        stylesheetQuestions.add(question);
        return question;
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
    public AbstractNode visit(Width width) {
        return null;
    }

    @Override
    public AbstractNode visit(Widget widget) {
        return null;
    }

    @Override
    public AbstractNode visit(Font font) {
        return null;
    }

    @Override
    public AbstractNode visit(Color color) {
        return null;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return null;
    }

}
