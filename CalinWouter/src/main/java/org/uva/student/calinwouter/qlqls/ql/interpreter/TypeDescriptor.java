package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.ql.types.Value;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;

// TODO add I before name
public interface TypeDescriptor<T extends Value<?>> {

    void callTypeMethod(TypeCallback typeCallback);

    T getDefaultValue();

    boolean isAllowed(IAllowTypeChecker allowable);
}
