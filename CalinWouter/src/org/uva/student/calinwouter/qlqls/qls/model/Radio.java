package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

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

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        // TODO apply state to this object.
    }
}
