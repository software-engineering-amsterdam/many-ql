package org.uva.student.calinwouter.ql.interpreter;

import org.uva.student.calinwouter.ql.generated.lexer.Lexer;
import org.uva.student.calinwouter.ql.generated.node.AForm;
import org.uva.student.calinwouter.ql.generated.node.AFormBegin;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.generated.parser.Parser;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.gui.GuiFormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.typechecker.FormTypeChecker;

import java.io.PushbackReader;
import java.io.StringReader;

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
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        try {
            Start ast = parser.parse();
            AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
            FormTypeChecker formTypeChecker = new FormTypeChecker();
            form.apply(formTypeChecker);
//            formTypeChecker.launch(System.err, System.out);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
