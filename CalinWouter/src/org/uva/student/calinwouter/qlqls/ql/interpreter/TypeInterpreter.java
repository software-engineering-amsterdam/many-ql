package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.ql.types.TString;

/**
 * This ql parses a type production and returns a TypeCallback implementation based on the type.
 */
public class TypeInterpreter extends AnalysisAdapter {

    private TypeDescriptor value;

    @Override
    public void caseABoolType(final ABoolType node) {
        setValue(new TypeDescriptor<TBool>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesBoolean();
            }

            @Override
            public TBool getDefaultValue() {
                return new TBool(false);
            }

            @Override
            public String toString() {
                return TBool.TYPE_REFERENCE;
            }
        });
    }

    @Override
    public void caseAIntType(final AIntType node) {
        setValue(new TypeDescriptor<TInteger>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesInteger();
            }

            @Override
            public TInteger getDefaultValue() {
                return new TInteger(null);
            }

            @Override
            public String toString() {
                return TInteger.TYPE_REFERENCE;
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
            public TString getDefaultValue() {
                return new TString("");
            }

            @Override
            public String toString() {
                return TString.TYPE_REFERENCE;
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
