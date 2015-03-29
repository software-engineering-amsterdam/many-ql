package org.uva.student.calinwouter.qlqls;

import org.uva.student.calinwouter.qlqls.ql.QLGUI;
import org.uva.student.calinwouter.qlqls.ql.helper.QLHelper;
import org.uva.student.calinwouter.qlqls.qls.QLSGUI;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.QLTypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.qls.helper.QLSHelper;
import org.uva.student.calinwouter.qlqls.qls.model.QLSTypeCheckResults;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static String readFile(String filename) throws IOException {
        BufferedReader reader = null;
        try {
            String line;
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

    private static boolean executeQl(String ql) {
        try {
            final QLTypeCheckResults QLTypeCheckResults = QLHelper.typeCheckString(ql);
            final String typeCheckResults = QLTypeCheckResults.toString();
            System.out.println(typeCheckResults);
            if (!QLTypeCheckResults.hasErrors()) {
                final StaticFields staticFields = QLHelper.analyzeQlString(ql);
                final QLInterpreter qlInterpreter = QLHelper.interpretQlString(ql);
                final VariableTable newVariableTable = new VariableTable();
                final QLGUI gui = new QLGUI(qlInterpreter, qlInterpreter.interpret(newVariableTable), staticFields);
                gui.render();
                return true;
            }
            System.out.println("QL not running due to errors.");
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private static void executeQlQls(String ql, String qls) {
        try {
            final StaticFields staticFields = QLHelper.analyzeQlString(ql);
            final QLInterpreter qlInterpreter = QLHelper.interpretQlString(ql);
            final StyleSheet styleSheet = QLSHelper.interpretStylesheetString(qls);
            final QLSTypeCheckResults typeCheckResults = QLSHelper.typeCheckStyleSheet(styleSheet, staticFields);
            if (typeCheckResults.hasErrors()) {
                System.out.println("QLS not running due to errors.");
            }
            final VariableTable newVariableTable = new VariableTable();
            final QLSGUI gui = new QLSGUI(styleSheet, qlInterpreter, qlInterpreter.interpret(newVariableTable), staticFields);
            System.out.println(typeCheckResults);
            gui.render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main starts both ql and qls.
     */
    public static void main(String[] args) throws IOException {
        final String currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        final String ql = readFile(currentLocation + "../../src/main/resources/ql.txt");
        final String qls = readFile(currentLocation + "../../src/main/resources/qls.txt");
        if (executeQl(ql)) {
            executeQlQls(ql, qls);
        }
    }

}
