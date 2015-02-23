package org.uva.student.calinwouter.qlqls.qls.model;

import java.util.EventListener;

public abstract class ModelUpdateListener<T> implements EventListener {

    public abstract void onUpdateEvent(T t);

}
