package edu;

import edu.exceptions.CloneException;
import edu.exceptions.ParseException;
import edu.gui.Observer;
import edu.gui.Renderer;
import edu.gui.components.CheckBox;
import edu.gui.components.TextBox;
import edu.parser.AntlrParser;
import edu.parser.QL.*;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.Identifier;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.QLSAntlrParser;
import edu.parser.QLS.nodes.Stylesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 24/02/2015.
 */
public class Main implements Observer {

    public static final String PATH_TO_QL_INPUT_FILES = "src/test/resources/antlr/input/QL/";
    public static final String PATH_TO_QLS_INPUT_FILES = "src/test/resources/antlr/input/QLS/";

    private final AntlrParser qlParser;
    private final AntlrParser qlsParser;
    private final TypeChecker typeChecker;
    private final Evaluator evaluator;
    private final edu.parser.QLS.TypeChecker qlsTypeChecker;
    private final Renderer renderer;
    private final Form form;
    private final Stylesheet stylesheet;
    private Set<Question> updatedQuestions;
    private List<Question> evaluatedQuestions;

    public Main() {
        qlParser = new QLAntlrParser();
        qlsParser = new QLSAntlrParser();
        typeChecker = new TypeChecker();
        evaluator = new Evaluator();
        qlsTypeChecker = new edu.parser.QLS.TypeChecker();
        renderer = new Renderer(this);
        form = parseQL();
        typeChecker.visit(form);
        stylesheet = parseQLS();
        updatedQuestions = new HashSet<>();
        evaluatedQuestions = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        evaluateForm();
        qlsTypeChecker.start(getAllFormQuestions(form), stylesheet);
        renderer.render(evaluatedQuestions, stylesheet);
    }
    public void reRender(){
        evaluateForm();
        qlsTypeChecker.start(getAllFormQuestions(form), stylesheet);
        renderer.reRender(evaluatedQuestions, stylesheet);
    }

    private void evaluateForm() {
        evaluatedQuestions.clear();
        evaluatedQuestions = evaluator.evaluate(form, updatedQuestions);
    }

    private Stylesheet parseQLS() {
        try {
            return qlsParser.parse(PATH_TO_QLS_INPUT_FILES + "QLS_gui", new edu.parser.QLS.ParseTreeVisitor(), Stylesheet.class);
        } catch (IOException e) {
            throw new ParseException(e);
        }
    }

    private Form parseQL() {
        try {
            return qlParser.parse(PATH_TO_QL_INPUT_FILES + "QL_gui", new ParseTreeVisitor(), Form.class);
        } catch (IOException e) {
            throw new ParseException(e);
        }
    }

    private static List<Question> getAllFormQuestions(Form form) {
        QuestionRetriever questionRetriever = new QuestionRetriever();
        return questionRetriever.retrieveQuestions(form);
    }

    @Override
    public void update(TextBox textBox) {
        int i = 0;
    }

    @Override
    public void update(CheckBox checkBox) {

        Question question = getEvaluatedQuestion(checkBox.getIdentifier());
        Question clonedQuestion = cloneQuestionAndSetState(checkBox.isSelected(), question);
        addUpdatedQuestion(clonedQuestion);

        reRender();

    }

    private void addUpdatedQuestion(Question clonedQuestion) {
        if (updatedQuestions.contains(clonedQuestion)) {
            updatedQuestions.remove(clonedQuestion);
        }
        updatedQuestions.add(clonedQuestion);
    }

    private Question cloneQuestionAndSetState(boolean isSelected, Question question) {
        try {
            return question.clone(isSelected);
        } catch (CloneNotSupportedException e) {
            throw new CloneException(e);
        }
    }

    public Question getEvaluatedQuestion(Identifier identifier) {
        List<Question> question = evaluatedQuestions.stream()
                .filter(q -> q.getIdentifier().equals(identifier))
                .collect(Collectors.toList());
        if (question.isEmpty()) {
            throw new IllegalArgumentException("cannot find question with identifier: " + identifier);
        } else if (question.size() > 1) {
            throw new IllegalArgumentException("UpdatedQuestions has duplicate items for identifier: " + identifier);
        } else {
            return question.get(0);
        }
    }
}
