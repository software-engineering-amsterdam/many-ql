package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.typechecker.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

// TODO add I before name
public interface TypeDescriptor<T extends Value<?>> {

    void callTypeMethod(TypeCallback typeCallback);

    T getDefaultValue();

    boolean isAllowed(IAllowTypeChecker allowable);
}
