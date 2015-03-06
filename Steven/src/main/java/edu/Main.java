package edu;

import edu.gui.MainWindow;
import edu.parser.AntlrParser;
import edu.parser.QL.Evaluator;
import edu.parser.QL.QLAntlrParser;
import edu.parser.QL.ParseTreeVisitor;
import edu.parser.QL.TypeChecker;
import edu.parser.QL.nodes.Form;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Steven Kok on 24/02/2015.
 */
public class Main {

    public static final String PATH_TO_QL_INPUT_FILES = "src/test/resources/antlr/input/QL/";
    public static final String PATH_TO_QLS_INPUT_FILES = "src/test/resources/antlr/input/QLS/";

    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        MainWindow mainWindow = new MainWindow();

        AntlrParser antlrParser = new QLAntlrParser();
        Form form = antlrParser.parse(PATH_TO_QL_INPUT_FILES + "QL_valid", new ParseTreeVisitor(), Form.class);
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form);
        Evaluator evaluator = new Evaluator();
        Form evaluatedForm = (Form) evaluator.evaluate(form);

        SwingUtilities.invokeLater(() -> mainWindow.initialize(evaluatedForm));

    }
}
