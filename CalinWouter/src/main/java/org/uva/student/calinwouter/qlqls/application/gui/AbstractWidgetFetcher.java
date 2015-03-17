package org.uva.student.calinwouter.qlqls.application.gui;


import org.uva.student.calinwouter.qlqls.ql.types.Value;

//TODO this class is not used anymore, but maybe it would be good to have an abstraction of the QL and QLS widget fetcher
public abstract  class AbstractWidgetFetcher<T> {

    T createWidget(Value value) { return null; }
}
