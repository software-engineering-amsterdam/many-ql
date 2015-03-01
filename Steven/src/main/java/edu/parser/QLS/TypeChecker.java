package edu.parser.QLS;

import edu.exceptions.TypeCheckException;
import edu.parser.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QLS.nodes.*;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.styles.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 01/03/2015.
 */
public class TypeChecker implements Visitor {
    public static final String UNIDENTIFIED_STYLESHEET_QUESTION = "Stylesheet contains questions that are not contained in the form. Unknown question identifiers:";
    private final List<Question> stylesheetQuestions;

    public TypeChecker() {
        this.stylesheetQuestions = new ArrayList<>();
    }

    public void start(Stylesheet stylesheet, Form form) {
        accept(stylesheet);

        confirmQuestionsExistInForm(getQuestions(form));
    }

    private void confirmQuestionsExistInForm(List<edu.parser.QL.nodes.question.Question> formQuestions) {
        List<Question> notFoundQuestions = stylesheetQuestions.stream()
                .filter(stylesheetQuestion ->
                                formQuestions.stream()
                                        .noneMatch(doesFormQuestionsContainStylesheetQuestion(stylesheetQuestion))
                )
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

    private List<edu.parser.QL.nodes.question.Question> getQuestions(Form form) {
        return form.getElements()
                .stream()
                .filter(element -> element instanceof edu.parser.QL.nodes.question.Question)
                .map(statement -> (edu.parser.QL.nodes.question.Question) statement)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode accept(Stylesheet stylesheet) {
        return stylesheet;
    }

    @Override
    public AbstractNode accept(Page page) {
        return null;
    }

    @Override
    public AbstractNode accept(Style style) {
        return null;
    }

    @Override
    public AbstractNode accept(Question question) {
        stylesheetQuestions.add(question);
        return question;
    }

    @Override
    public AbstractNode accept(Identifier identifier) {
        return null;
    }

    @Override
    public AbstractNode accept(Section section) {
        return null;
    }

    @Override
    public AbstractNode accept(Default aDefault) {
        return null;
    }

    @Override
    public AbstractNode accept(QuestionType questionType) {
        return null;
    }
}
