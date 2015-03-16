package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFieldsList;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

public class QLTypeChecker {

    /**
     * Type check the provided form.
     * @return the type check results.
     */
    public static TypeCheckResults typeCheck(AForm aForm) {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        StaticFieldsList staticFieldsList = QLStaticAnalyser.collectTypes(aForm);
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFieldsList, typeCheckResults);
        aForm.apply(formTypeChecker);
        return typeCheckResults;
    }

}
