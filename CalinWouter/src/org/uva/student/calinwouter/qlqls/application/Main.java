package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.application.gui.qls.StyleSheetRenderer;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Default;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import java.util.LinkedList;

public class Main {

    /** For each change, the QL interpreter is called. The stylesheet's model remains the same, but changes
     * based on the results of QL. */
    public static void main(String[] args) {
        String input = "form Box1HouseOwning {\n" +
                " hasSoldHouse: \"Did you by a house in 2010?\" boolean\n" +
                " hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n" +
                " if (hasSoldHouse) {\n" +
                " sellingPrice: \"Price the house was sold for:\" int\n" +
                " privateDebt: \"Private debts for the sold house:\" int\n" +
                " valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n" +
                " }\n" +
                "}";
        try {
            HeadlessFormInterpreter headlessFormInterpreter = InterpreterHelper.initializeHeadlessInterpreter(input);

            FormTypeChecker formTypeChecker = InterpreterHelper.typeCheckString(input);

            input = "styleSheet(taxOfficeExample," +
                    "" +
                    "\tpage(Housing,\n" +
                    "\t\tsection(Buying,\n" +
                    "\t\t\tquestion(hasBoughtHouse, {widget: checkbox})),\n" +
                    "\t\tsection(Loaning,\n" +
                    "\t\t\tquestion(hasMaintLoan))\n" +
                    "\t), page(Selling,\n" +
                    "\t\tsection(Selling,\n" +
                    "\t\t\tquestion(hasSoldHouse, {widget: radio(\"Yes\", \"No\")})), \n" +
                    "\t\tsection(\"You sold a house\",\n" +
                    "\t\t\tquestion(sellingPrice, {widget: spinbox}),\n" +
                    "\t\t\tquestion(privateDebt, {widget: spinbox}),\n" +
                    "\t\t\tcomputedValue(valueResidue)),\n" +
                    "\t\tdefault(int, {\n" +
                    "\t\t\twidth: 400,\n" +
                    "\t\t\tfont: \"Arial\",\n" +
                    "\t\t\tfontsize: 14,\n" +
                    "\t\t\tcolor: #999999,\n" +
                    "\t\t\twidget: spinbox\n" +
                    "\t\t})\n" +
                    "\t), default(boolean, {widget: radio(\"Yes\", \"No\")})\n" +
                    ")";


            // Create a static stylesheet.
            StyleSheet styleSheet = (StyleSheet) InterpreterHelper.interpetStylesheetString(input).getValue().getValue();

            // Apply QL to the stylesheet renderer.
            styleSheet.apply(new StyleSheetRenderer(headlessFormInterpreter, formTypeChecker));

            headlessFormInterpreter.interpret();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
