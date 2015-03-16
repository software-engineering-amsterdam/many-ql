package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFieldsList;
import org.uva.student.calinwouter.qlqls.ql.typechecker.TypeCollector;

public class QLStaticAnalyser {

    /**
     * Create the static representation of the model (i.e. collect the fields, etc.).
     */
    public static StaticFieldsList collectStaticFields(AForm form) {
        StaticFieldsList staticFieldsList = new StaticFieldsList();
        TypeCollector typeCollector = new TypeCollector(staticFieldsList);
        form.apply(typeCollector);
        return staticFieldsList;
    }

}
