package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.PFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

public class QLInterpreter {
    private final AForm aForm;

    public VariableTable interpret(VariableTable oldVariableTable) {
        VariableTable newVariableTable = new VariableTable();
        PFormInterpreter formInterpreter = new PFormInterpreter(oldVariableTable, newVariableTable);
        aForm.apply(formInterpreter);
        return newVariableTable;
    }

    public QLInterpreter(AForm aForm) {
        this.aForm = aForm;
    }

}
