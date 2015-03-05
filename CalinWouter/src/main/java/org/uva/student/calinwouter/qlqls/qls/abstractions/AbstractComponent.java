package org.uva.student.calinwouter.qlqls.qls.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.TypeToWidgetSettingsModel;

public abstract class AbstractComponent extends AbstractModel {
    protected TypeToWidgetSettingsModel typeToWidgetSettingsModel;
    protected AbstractComponent parent;

    public AbstractComponent() {
        typeToWidgetSettingsModel = new TypeToWidgetSettingsModel();
    }

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }

    public AbstractComponent getParent() {
        return parent;
    }

    /**
     * Get a TypeToWidgetSettingsModel, allowing the user to fetch the widget settings model by type.
     * @return a TypeToWidgetSettingsModel, allowing the user to fetch the widget settings model by type.
     */
    public TypeToWidgetSettingsModel getTypeToWidgetSettingsModel() {
        return getParent().getTypeToWidgetSettingsModel();
    }
}
