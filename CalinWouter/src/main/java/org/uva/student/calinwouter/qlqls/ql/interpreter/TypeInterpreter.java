package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

/**
 * This ql parses a type production and returns a TypeCallback implementation based on the type.
 */
public class TypeInterpreter extends AnalysisAdapter {

    private TypeDescriptor value;

    @Override
    public void caseABoolType(final ABoolType node) {
        setValue(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseAIntType(final AIntType node) {
        setValue(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseAStringType(final AStringType node) {
        setValue(StringValue.STRING_VALUE_TYPE_DESCRIPTOR);
    }

    private void setValue(TypeDescriptor value) {
        this.value = value;
    }

    public TypeDescriptor getValue() {
        return value;
    }

}
