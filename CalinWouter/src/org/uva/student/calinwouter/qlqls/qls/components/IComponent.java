package org.uva.student.calinwouter.qlqls.qls.components;

import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

public interface IComponent {

    public AbstractPushable<?> interop(Object... args);

}
