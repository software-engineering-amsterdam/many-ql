package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;

public class Main {

    public static void main(String[] args) {
        String input = "form Box1HouseOwning {\n" +
                " hasSoldHouse: \"Did you by a house in 2010?\" boolean\n" +
                " hasSoldHouse3: \"Did you by a house in 2010?\" boolean\n" +
                " hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n" +
                " if (hasSoldHouse) {\n" +
                " sellingPrice: \"Price the house was sold for:\" int\n" +
                " privateDebt: \"Private debts for the sold house:\" int\n" +
                " valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n" +
                " }\n" +
                "}";
        try {
            InterpreterHelper.interpetString(input);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
