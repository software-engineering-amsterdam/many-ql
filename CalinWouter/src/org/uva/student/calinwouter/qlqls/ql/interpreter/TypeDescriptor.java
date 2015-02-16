package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;

public interface TypeDescriptor<T extends TypeModel<?>> {

    void callTypeMethod(TypeCallback typeCallback);

    T getDefaultValue();

}
