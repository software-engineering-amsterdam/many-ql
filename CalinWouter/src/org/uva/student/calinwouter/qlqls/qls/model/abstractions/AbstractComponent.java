package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import java.util.HashMap;

public abstract class AbstractComponent<T> extends AbstractModel<T> {
    private AbstractComponent<?> parent;

    protected AbstractComponent<?> getParent() {
        return parent;
    }

    public void setParent(AbstractComponent<?> parent) {
        this.parent = parent;
    }

    public HashMap<String, HashMap<Object, Object>> getWidgetSettings() {
        return parent.getWidgetSettings();
    }

}
