package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.PFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.ResultingFieldsCollection;

public class QLInterpreter {

    /**
     * Interpret the provided form using the provided variable table.
     * @return the collected fields.
     */
    public ResultingFieldsCollection interpret(AForm aForm, VariableTable variableTable) {
        ResultingFieldsCollection form = new ResultingFieldsCollection();
        PFormInterpreter formInterpreter = new PFormInterpreter(variableTable, form);
        aForm.apply(formInterpreter);
        return form;
    }

}
