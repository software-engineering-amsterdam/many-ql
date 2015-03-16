package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

public class QLTypeChecker {
    private final AForm aForm;
    private final StaticFields staticFields;

    public TypeCheckResults typeCheck() {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFields, typeCheckResults);
        aForm.apply(formTypeChecker);
        return typeCheckResults;
    }

    public QLTypeChecker(AForm aForm, StaticFields staticFields) {
        this.aForm = aForm;
        this.staticFields = staticFields;
    }

    public QLTypeChecker(AForm aForm) {
        this(aForm, new QLStaticAnalyser(aForm).collectStaticFields());
    }

}
