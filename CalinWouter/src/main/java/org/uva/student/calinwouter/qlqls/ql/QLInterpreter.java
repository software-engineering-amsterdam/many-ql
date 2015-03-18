package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.PFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

public class QLInterpreter {
    private final AForm aForm;
    private final StaticFields staticFields;

    public VariableTable interpret(VariableTable oldVariableTable) {
        VariableTable newVariableTable = new VariableTable();
        PFormInterpreter formInterpreter = new PFormInterpreter(oldVariableTable, newVariableTable, staticFields);
        aForm.apply(formInterpreter);
        return newVariableTable;
    }

    public QLInterpreter(AForm aForm, StaticFields staticFields) {
        this.aForm = aForm;
        this.staticFields = staticFields;
    }

    private static StaticFields collectStaticFields(AForm aForm) {
        return new QLStaticAnalyser(aForm).collectStaticFields();
    }

    public QLInterpreter(AForm aForm) {
        this(aForm, collectStaticFields(aForm));
    }

}
