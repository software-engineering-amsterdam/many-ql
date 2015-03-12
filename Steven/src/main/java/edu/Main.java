package edu;

import edu.exceptions.ParseException;
import edu.gui.Observer;
import edu.gui.Renderer;
import edu.gui.components.CheckBox;
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
public class Main implements Observer { //todo: remove cloneable from project, use copy constructors

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

    public void reRender() {
        evaluateForm();
        qlsTypeChecker.start(getAllFormQuestions(form), stylesheet);
        renderer.reRender(evaluatedQuestions, stylesheet);
    }

    private void evaluateForm() {
        evaluatedQuestions.clear();
        evaluatedQuestions = evaluator.evaluate(form);
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
        Question question = getEvaluatedQuestion(textBox.getQLIdentifier());
        question.setValue(new Text(textBox.getText()));
        reRender();
    }

    @Override
    public void initializeRequest(TextBox textBox) {
        Question question = getEvaluatedQuestion(textBox.getQLIdentifier());
        textBox.setText(question.getValue().getValue());
        if (computedQuestion(question)) {
            textBox.setEditable(false); //grey out
            textBox.removeEventListeners(); //do not update for computed questions
        }
    }

    private boolean computedQuestion(Question question) {
        return question.getExpression().isPresent();
    }

    @Override
    public void update(CheckBox checkBox) {
        Question question = getEvaluatedQuestion(checkBox.getQLIdentifier());
        question.setState(checkBox.isSelected());
        reRender();
    }

    @Override
    public void initializeRequest(CheckBox checkBox) {
        Question question = getEvaluatedQuestion(checkBox.getQLIdentifier());
        checkBox.setSelected(question.isEnabled());
    }

    public Question getEvaluatedQuestion(QLIdentifier QLIdentifier) {
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
