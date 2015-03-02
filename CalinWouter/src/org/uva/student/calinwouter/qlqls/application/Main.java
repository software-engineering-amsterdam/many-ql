package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.application.gui.ql.FormRenderer;
import org.uva.student.calinwouter.qlqls.application.gui.qls.StyleSheetRenderer;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String readFile(String filename) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String lineSeparator = System.getProperty("line.separator");
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(lineSeparator);
            }
            return stringBuilder.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private static void printAbout() {
        System.out.println("QL / QLS by Calin Borlovan + Wouter Nederhof.");
        System.out.println("    Please use --help for the syntax.");
        System.out.println();
        System.out.println("Usage: java -jar CalinWouter.jar <args>");
        System.out.println();
    }

    private static void printSyntax() {
        System.out.println("Available arguments:");
        System.out.println("");
        System.out.println("<no arguments>:         demo reel");
        System.out.println("--help:                 shows this help");
        System.out.println("1 file argument:        displays the QL form.");
        System.out.println("1 file arguments:       displays the QL form (first argument) using QLS (second argument).");
    }

    private static void executeQlQls(String ql, String qls) {
        try {
            HeadlessFormInterpreter headlessFormInterpreter;
            FormTypeChecker formTypeChecker;
            StyleSheet styleSheet;

            headlessFormInterpreter = InterpreterHelper.initializeHeadlessInterpreter(ql);
            formTypeChecker = InterpreterHelper.typeCheckString(ql);
            styleSheet = (StyleSheet) InterpreterHelper.interpetStylesheetString(qls).getValue().getValue();

            styleSheet.apply(new StyleSheetRenderer(headlessFormInterpreter, formTypeChecker));
            headlessFormInterpreter.interpret();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private static void executeQl(String ql) {
        try {

            HeadlessFormInterpreter headlessFormInterpreter;
            FormTypeChecker formTypeChecker;

            headlessFormInterpreter = InterpreterHelper.initializeHeadlessInterpreter(ql);
            formTypeChecker = InterpreterHelper.typeCheckString(ql);

            FormRenderer formRenderer = new FormRenderer(headlessFormInterpreter, formTypeChecker);
            formRenderer.render();

            headlessFormInterpreter.interpret();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** For each change, the QL interpreter is called. The stylesheet's model remains the same, but changes
     * based on the results of QL. */
    public static void main(String[] args) throws IOException {
        printAbout();
        if (args.length == 0) {
            String currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String ql = readFile(currentLocation + "org/uva/student/calinwouter/qlqls/resources/examples/simple/ql.txt");
            String qls = readFile(currentLocation + "org/uva/student/calinwouter/qlqls/resources/examples/simple/qls.txt");
            executeQlQls(ql, qls);
        } else if (args.length == 2) {
            String ql = readFile(args[0]);
            String qls = readFile(args[1]);
            executeQlQls(ql, qls);
        } else if (args.length == 1 && args[0].equals("--help")) {
            printSyntax();
        } else if (args.length == 1) {
            //String currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            //String ql = readFile(currentLocation + "org/uva/student/calinwouter/qlqls/resources/examples/simple/ql.txt");
            executeQl(ql);
        }
    }


}
