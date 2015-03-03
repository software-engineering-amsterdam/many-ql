package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.TypeToWidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Default;

public abstract class AbstractComponent<T> extends AbstractModel<T> {
    protected TypeToWidgetSettingsModel typeToWidgetSettingsModel;
    protected AbstractComponent<?> parent;

    public AbstractComponent() {
        typeToWidgetSettingsModel = new TypeToWidgetSettingsModel();
    }

    public void setParent(AbstractComponent<?> parent) {
        this.parent = parent;
    }

    public AbstractComponent<?> getParent() {
        return parent;
    }

    public TypeToWidgetSettingsModel getTypeToWidgetSettingsModel() {
        return getParent().getTypeToWidgetSettingsModel();
    }

    @Override
    public void caseDefault(Default defaultSetting) {
        try {
            typeToWidgetSettingsModel = new TypeToWidgetSettingsModel(
                    typeToWidgetSettingsModel,
                    defaultSetting.getType(),
                    defaultSetting.getWidgetSettingsModel());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
