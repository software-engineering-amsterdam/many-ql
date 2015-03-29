package org.uva.student.calinwouter.qlqls.ql.typechecker;


import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

public class UndefinedTypeDescriptor implements ITypeDescriptor{

    public void callTypeMethod(ITypeCallback typeCallback) {

    }

    public Value getDefaultValue() {
        return null;
    }

    public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
        return false;
    }

}
