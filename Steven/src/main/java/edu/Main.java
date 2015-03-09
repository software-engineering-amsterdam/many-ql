package edu;

import edu.gui.Observer;
import edu.gui.Renderer;
import edu.gui.components.CheckBox;
import edu.gui.components.TextBox;
import edu.parser.AntlrParser;
import edu.parser.QL.*;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.QLSAntlrParser;
import edu.parser.QLS.nodes.Stylesheet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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
    private List<Question> updatedQuestions;

    public Main() throws IOException {
        qlParser = new QLAntlrParser();
        qlsParser = new QLSAntlrParser();
        typeChecker = new TypeChecker();
        evaluator = new Evaluator();
        qlsTypeChecker = new edu.parser.QLS.TypeChecker();
        renderer = new Renderer(this);
        form = parseQL();
        typeChecker.visit(form);
        stylesheet = parseQLS();
        updatedQuestions = new ArrayList<>();
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        Main main = new Main();
        main.execute();
    }

    public void execute() throws IOException {

        List<Question> evaluatedQuestions = evaluator.evaluate(form, updatedQuestions);
        updatedQuestions = evaluatedQuestions;
        qlsTypeChecker.start(getAllFormQuestions(form), stylesheet);
        renderer.render(evaluatedQuestions, stylesheet);
    }

    private Stylesheet parseQLS() throws IOException {
        return qlsParser.parse(PATH_TO_QLS_INPUT_FILES + "QLS_gui", new edu.parser.QLS.ParseTreeVisitor(), Stylesheet.class);
    }

    private Form parseQL() throws IOException {
        return qlParser.parse(PATH_TO_QL_INPUT_FILES + "QL_gui", new ParseTreeVisitor(), Form.class);
    }

    private static List<Question> getAllFormQuestions(Form form) {
        QuestionRetriever questionRetriever = new QuestionRetriever();
        return questionRetriever.retrieveQuestions(form);
    }

    @Override
    public void update(TextBox textBox) {
    }

    @Override
    public void update(CheckBox checkBox) {
    }
}
