package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.TypeToWidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Default;

public abstract class AbstractComponent<T> extends AbstractModel<T> {
    protected TypeToWidgetSettingsModel typeToWidgetSettingsModel;
    protected AbstractComponent<?> parent;

    public AbstractComponent() {
        super();
        typeToWidgetSettingsModel = new TypeToWidgetSettingsModel();
    }

    public void setParent(AbstractComponent<?> parent) {
        this.parent = parent;
    }

    public AbstractComponent<?> getParent() {
        if (parent == null)
            System.out.println("NOOO" + this.getClass());
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
