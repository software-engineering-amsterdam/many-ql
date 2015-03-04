package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
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
        setValue(new TypeDescriptor<BoolValue>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesBoolean();
            }

            @Override
            public BoolValue getDefaultValue() {
                return new BoolValue(false);
            }

            @Override
            public String toString() {
                return BoolValue.TYPE_REFERENCE;
            }
        });
    }

    @Override
    public void caseAIntType(final AIntType node) {
        setValue(new TypeDescriptor<IntegerValue>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesInteger();
            }

            @Override
            public IntegerValue getDefaultValue() {
                return new IntegerValue(null);
            }

            @Override
            public String toString() {
                return IntegerValue.TYPE_REFERENCE;
            }
        });
    }

    @Override
    public void caseAStringType(final AStringType node) {
        setValue(new TypeDescriptor() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesString();
            }

            @Override
            public StringValue getDefaultValue() {
                return new StringValue("");
            }

            @Override
            public String toString() {
                return StringValue.TYPE_REFERENCE;
            }
        });
    }

    private void setValue(TypeDescriptor value) {
        this.value = value;
    }

    public TypeDescriptor getValue() {
        return value;
    }

}
