package edu;

import edu.gui.MainWindow;
import edu.parser.AntlrParser;
import edu.parser.ParseTreeWalker;
import edu.parser.nodes.Form;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Steven Kok on 24/02/2015.
 */
public class Main {

    public static final String PATH_TO_INPUT_FILES = "src/test/resources/antlr/input/";

    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        MainWindow mainWindow = new MainWindow();

        AntlrParser antlrParser = new AntlrParser();
        Form form = antlrParser.walk(PATH_TO_INPUT_FILES + "QL_valid", new ParseTreeWalker(), Form.class);
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form);
        Evaluator evaluator = new Evaluator();
        Form evaluatedForm = (Form) evaluator.visit(form);

        SwingUtilities.invokeLater(() -> mainWindow.initialize(evaluatedForm));

    }
}
