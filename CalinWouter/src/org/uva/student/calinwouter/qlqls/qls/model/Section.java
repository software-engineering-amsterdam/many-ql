package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

import java.util.LinkedList;
import java.util.List;

public class Section extends AbstractModel<Section> {
    private List<AbstractFormField<?>> fields;
    private List<Default> defaults; // TODO defaults...

    @Override
    public void caseQuestion(Question question) {
        fields.add(question);
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        fields.add(computedValue);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseSection(this);
    }

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        for (AbstractFormField<?> field : fields) {
            field.updateStates(headlessFormInterpreter, defaultList);
        }
    }

    public Section() {
        fields = new LinkedList<AbstractFormField<?>>();
    }
}
