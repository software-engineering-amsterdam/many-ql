package edu;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.exceptions.ParseException;
import edu.gui.DefaultRenderer;
import edu.gui.Observer;
import edu.gui.components.CheckBox;
import edu.gui.components.NumberBox;
import edu.gui.components.TextBox;
import edu.parser.AntlrParser;
import edu.parser.QL.ParseTreeVisitor;
import edu.parser.QL.QLAntlrParser;
import edu.parser.QL.QuestionRetriever;
import edu.parser.QL.evaluator.Evaluator;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.QLIdentifier;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.type.Text;
import edu.parser.QL.typechecker.TypeChecker;
import edu.parser.QLS.QLSAntlrParser;
import edu.parser.QLS.nodes.Stylesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private final ArgumentParserResult inputFileLocation;
    private final Form form;
    private final DefaultRenderer defaultRenderer;
    List<Question> evaluatedQuestions;

    public Main(ArgumentParserResult inputFileLocation) {
        this.inputFileLocation = inputFileLocation;
        qlParser = new QLAntlrParser();
        qlsParser = new QLSAntlrParser();
        typeChecker = new TypeChecker();
        evaluator = new Evaluator();
        qlsTypeChecker = new edu.parser.QLS.TypeChecker();
        form = parseQL();
        defaultRenderer = new DefaultRenderer(this);
        evaluatedQuestions = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            ArgumentParser argumentParser = new ArgumentParser();
            ArgumentParserResult inputFileLocation = argumentParser.parse(args);
            Main main = new Main(inputFileLocation);
            main.start(inputFileLocation);
        } catch (InvalidArgumentException e) {
            showErrorWindow(e.getRealMessage());
        }
    }

    private static void showErrorWindow(String errorMessage) {
        //todo create window with error message
    }

    public void start(ArgumentParserResult inputFileLocation) {
        if (isQLSFileAvailable(inputFileLocation)) {
            startWithQLS();
        } else {
            startWithoutQLS();
        }
    }

    private boolean isQLSFileAvailable(ArgumentParserResult inputFileLocation) {
        return inputFileLocation.getQLSFileLocation().isPresent();
    }

    private void startWithoutQLS() {
        Form form = parseQL();
        typeChecker.visit(form);
        evaluatedQuestions = evaluateForm(form);
        defaultRenderer.render(evaluatedQuestions);
    }

    private void startWithQLS() {
        typeChecker.visit(form);
        Stylesheet stylesheet = parseQLS();
        evaluatedQuestions = evaluateForm(form);
        qlsTypeChecker.start(getAllFormQuestions(form), stylesheet);
    }

    public void reRender() {
        List<Question> evaluatedQuestions = evaluateForm(form);
        defaultRenderer.reRender(evaluatedQuestions);
    }

    private List<Question> evaluateForm(Form form) {
        return evaluator.evaluate(form);
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

    private List<Question> getAllFormQuestions(Form form) {
        QuestionRetriever questionRetriever = new QuestionRetriever();
        return questionRetriever.retrieveQuestions(form);
    }

    @Override
    public void update(TextBox textBox) {
        Question question = getEvaluatedQuestion(textBox.getIdentifier());
        question.setValue(new Text(textBox.getText()));
        reRender();
    }

    @Override
    public void update(CheckBox checkBox) {
        Question question = getEvaluatedQuestion(checkBox.getIdentifier());
        question.setState(checkBox.isSelected());
        reRender();
    }

    @Override
    public void update(NumberBox numberBox) {
        Question question = getEvaluatedQuestion(numberBox.getIdentifier());
        question.setValue(new Text(numberBox.getText()));
        reRender();
    }

    private Question getEvaluatedQuestion(QLIdentifier QLIdentifier) {
        List<Question> question = evaluatedQuestions.stream()
                .filter(q -> q.getQLIdentifier().equals(QLIdentifier))
                .collect(Collectors.toList());
        if (question.isEmpty()) {
            throw new IllegalArgumentException("cannot find question with identifier: " + QLIdentifier);
        } else if (question.size() > 1) {
            throw new IllegalArgumentException("UpdatedQuestions has duplicate items for identifier: " + QLIdentifier);
        } else {
            return question.get(0);
        }
    }
}
