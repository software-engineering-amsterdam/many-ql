package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.interpreter.types.TypeModel;

public interface TypeDescriptor<T extends TypeModel<?>> {

    void callTypeMethod(TypeCallback typeCallback);

    T getDefaultValue();

}
