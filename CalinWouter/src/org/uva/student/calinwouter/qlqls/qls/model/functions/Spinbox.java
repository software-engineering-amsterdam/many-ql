package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

// TODO
public class Spinbox extends AbstractModel<Spinbox> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseSpinbox(this);
    }

}
