package org.uva.student.calinwouter.qlqls.application.gui;


import org.uva.student.calinwouter.qlqls.ql.types.Value;

public abstract  class AbstractWidgetFetcher<T> {

    T createWidget(Value value) { return null; }
}
