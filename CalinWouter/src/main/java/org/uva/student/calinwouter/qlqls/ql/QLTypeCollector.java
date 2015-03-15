package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTypeTable;
import org.uva.student.calinwouter.qlqls.ql.typechecker.TypeCollector;

public class QLTypeCollector {

    /**
     * Collect the list of static variable types.
     * @return a list of static variable types.
     */
    public static VariableTypeTable collectTypes(AForm form) {
        VariableTypeTable variableTypeTable = new VariableTypeTable();
        TypeCollector typeCollector = new TypeCollector(variableTypeTable);
        form.apply(typeCollector);
        return variableTypeTable;
    }

}
