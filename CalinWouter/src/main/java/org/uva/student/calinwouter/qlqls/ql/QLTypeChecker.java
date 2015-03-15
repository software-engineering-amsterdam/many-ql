package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTypeTable;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

public class QLTypeChecker {

    /**
     * Type check the provided form.
     * @return the type check results.
     */
    public static TypeCheckResults typeCheck(AForm aForm) {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        VariableTypeTable variableTypeTable = QLTypeCollector.collectTypes(aForm);
        PFormTypeChecker formInterpreter = new PFormTypeChecker(variableTypeTable, typeCheckResults);
        aForm.apply(formInterpreter);
        return typeCheckResults;
    }

}
