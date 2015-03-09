package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.application.gui.qls.QLSRenderer;
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
        String line;
        try {
            reader = new BufferedReader(new FileReader(filename));
            StringBuilder stringBuilder = new StringBuilder();
            String lineSeparator = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(lineSeparator);
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
//            FormTypeChecker formTypeChecker = InterpreterHelper.typeCheckString(ql);
            HeadlessFormInterpreter headlessFormInterpreter = InterpreterHelper.initializeHeadlessInterpreter(ql);
            StyleSheet styleSheet = (StyleSheet) InterpreterHelper.interpetStylesheetString(qls).getValue();
//            QLSRenderer.render(styleSheet, headlessFormInterpreter, formTypeChecker);
            headlessFormInterpreter.interpret();
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
