package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.HashMap;
import java.util.List;

public class Default extends AbstractModel<Default> {
    private TypeDescriptor<?> type;
    private WidgetSettingsModel widgetSettingsModel;

    public TypeDescriptor<?> getType() {
        return type;
    }

    @Override
    public void caseHashMap(HashMap<String, Object> hashMap) {
        try {
            widgetSettingsModel = new WidgetSettingsModel(hashMap);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WidgetSettingsModel getWidgetSettingsModel() {
        return widgetSettingsModel;
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
