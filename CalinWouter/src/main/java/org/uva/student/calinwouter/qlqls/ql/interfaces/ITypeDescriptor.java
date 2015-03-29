package org.uva.student.calinwouter.qlqls.ql.interfaces;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

public interface ITypeDescriptor {

    void callTypeMethod(ITypeCallback typeCallback);

    Value getDefaultValue();

    /**
     * Checks if this type is allowed by the provided consumer (e.g. widget).
     */
    boolean isAllowed(IAllowTypeChecker allowTypeChecker);

}
