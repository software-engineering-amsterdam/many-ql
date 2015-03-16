package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.typechecker.StaticFieldsCollector;

public class QLStaticAnalyser {
    private final AForm aForm;

    /**
     * Create the static representation of the model (i.e. collect the fields, etc.).
     */
    public StaticFields collectStaticFields() {
        StaticFields staticFields = new StaticFields();
        StaticFieldsCollector typeCollector = new StaticFieldsCollector(staticFields);
        aForm.apply(typeCollector);
        return staticFields;
    }

    public QLStaticAnalyser(AForm aForm) {
        this.aForm = aForm;
    }

}
