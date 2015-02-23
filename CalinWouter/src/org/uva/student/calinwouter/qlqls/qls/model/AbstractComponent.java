package org.uva.student.calinwouter.qlqls.qls.model;


public abstract class AbstractComponent<T> extends AbstractModel<T> {
    protected boolean visible;

    public boolean isVisible() {
        return visible;
    }
}
