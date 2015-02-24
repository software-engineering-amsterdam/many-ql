package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.HashMap;
import java.util.List;

public class Radio extends AbstractWidget<Radio> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseRadio(this);
    }

    @Override
    public void caseHashMap(HashMap<Object, Object> hashMap) {
        // TODO
    }

    @Override
    public void caseString(String string) {
        // TODO
    }
}
