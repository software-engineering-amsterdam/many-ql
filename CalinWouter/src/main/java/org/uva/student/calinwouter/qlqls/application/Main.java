package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.application.gui.qls.QLSGUI;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static String readFile(String filename) throws IOException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(filename));
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(LINE_SEPARATOR);
            }
            return stringBuilder.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void executeQlQls(String ql, String qls) {
        try {
            FormTypeChecker formTypeChecker = InterpreterHelper.typeCheckString(ql);
            FormInterpreter formInterpreter = InterpreterHelper.initializeHeadlessInterpreter(ql);
            StyleSheet styleSheet = InterpreterHelper.interpetStylesheetString(qls);
            formInterpreter.interpret();
            new QLSGUI(styleSheet, formInterpreter, formTypeChecker).render();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * For each change, the QL interpreter is called. The stylesheet's model remains the same, but changes
     * based on the results of QL.
     */
    public static void main(String[] args) throws IOException {
        String currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String ql = readFile(currentLocation + "../../src/main/resources/ql.txt");
        String qls = readFile(currentLocation + "../../src/main/resources/qls.txt");
        executeQlQls(ql, qls);
    }

}
