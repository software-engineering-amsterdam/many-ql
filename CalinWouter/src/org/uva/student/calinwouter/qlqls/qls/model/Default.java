package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

import java.util.List;

public class Default extends AbstractModel<Default> {

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        // This model does not alter on state updates.
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseDefault(this);
    }

}
