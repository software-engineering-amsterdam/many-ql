package org.uva.student.calinwouter.qlqls.ql.interpreter;

import java.util.EventListener;

public interface ChangedStateEventListener extends EventListener {

    public void onStateChanged();

}
