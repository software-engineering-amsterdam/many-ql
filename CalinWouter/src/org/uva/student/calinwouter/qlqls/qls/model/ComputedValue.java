package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

import java.util.List;

public class ComputedValue extends AbstractFormField<ComputedValue> {

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        // TODO apply state to this object.
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseComputedValue(this);
    }
}