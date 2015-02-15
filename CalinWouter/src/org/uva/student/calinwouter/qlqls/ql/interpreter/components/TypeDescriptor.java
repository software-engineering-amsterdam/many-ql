package org.uva.student.calinwouter.qlqls.ql.interpreter.components;

import org.uva.student.calinwouter.qlqls.ql.interpreter.types.TypeModel;

public interface TypeDescriptor<T extends TypeModel<?>> {

    void callTypeMethod(TypeCallback typeCallback);

    T getDefaultValue();

}
