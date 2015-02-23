package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;
import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

import java.util.HashMap;
import java.util.List;

public class Default extends AbstractModel<Default> {
    private TypeDescriptor<?> type;
    private HashMap<Object,Object> defaultTypeSettings;

    public TypeDescriptor<?> getType() {
        return type;
    }

    public HashMap<Object, Object> getDefaultTypeSettings() {
        return defaultTypeSettings;
    }

    @Override
    public void caseHashMap(HashMap<Object, Object> hashMap) {
        defaultTypeSettings = hashMap;
    }

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        // This model does not alter on state updates.
    }

    @Override
    public void caseTypeDescriptor(TypeDescriptor<?> typeDescriptor) {
        type = typeDescriptor;
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseDefault(this);
    }

}
