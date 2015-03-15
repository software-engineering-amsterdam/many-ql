package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTypeTable;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

public class QLTypeChecker {
    private final AForm aForm;

    public TypeCheckResults typeCheck() {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        PFormTypeChecker formInterpreter = new PFormTypeChecker(new VariableTypeTable(), typeCheckResults);
        aForm.apply(formInterpreter);
        return typeCheckResults;
    }

    public QLTypeChecker(AForm aForm) {
        this.aForm = aForm;
    }
}
