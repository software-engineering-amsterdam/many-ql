package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.staticfieldscollector.PFormStaticFieldsCollector;

public class QLStaticAnalyser {
    private final AForm aForm;

    public StaticFields collectStaticFields() {
        final StaticFields staticFields = new StaticFields();
        final PFormStaticFieldsCollector typeCollector = new PFormStaticFieldsCollector(staticFields);
        aForm.apply(typeCollector);
        return staticFields;
    }

    public QLStaticAnalyser(AForm aForm) {
        this.aForm = aForm;
    }

}
