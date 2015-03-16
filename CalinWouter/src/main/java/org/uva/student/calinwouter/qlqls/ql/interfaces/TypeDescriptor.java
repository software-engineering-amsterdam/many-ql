package org.uva.student.calinwouter.qlqls.ql.interfaces;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

// TODO add I before name
public interface TypeDescriptor {

    void callTypeMethod(TypeCallback typeCallback);

    Value getDefaultValue();

    boolean isAllowed(IAllowTypeChecker allowTypeChecker);

}
