package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.HashMap;
import java.util.List;

public class Default extends AbstractModel<Default> {
    private TypeDescriptor<?> type;
    private HashMap<Object,Object> defaultTypeSettings;

    public TypeDescriptor<?> getType() {
        return type;
    }

    // TODO utilize.
    public HashMap<Object, Object> getDefaultTypeSettings() {
        return defaultTypeSettings;
    }

    @Override
    public void caseHashMap(HashMap<Object, Object> hashMap) {
        defaultTypeSettings = hashMap;
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
