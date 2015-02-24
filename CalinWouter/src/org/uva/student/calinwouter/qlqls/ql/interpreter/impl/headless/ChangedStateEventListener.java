package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import java.util.EventListener;

public interface ChangedStateEventListener extends EventListener {

    public void onStateChanged();

}
