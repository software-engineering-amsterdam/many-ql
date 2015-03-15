package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.ResultingFieldsCollection;

public class QLIntepreter {
    private final AForm aForm;
    private final VariableTable variableTable;

    public ResultingFieldsCollection interpret() {
        ResultingFieldsCollection form = new ResultingFieldsCollection();
        PFormInterpreter formInterpreter = new PFormInterpreter(variableTable, form);
        aForm.apply(formInterpreter);
        return form;
    }

    public QLIntepreter(AForm aForm, VariableTable variableTable) {
        this.aForm = aForm;
        this.variableTable = variableTable;
    }
}
