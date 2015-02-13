package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.node.ABoolType;
import org.uva.student.calinwouter.ql.generated.node.AIntType;
import org.uva.student.calinwouter.ql.generated.node.AStringType;
import org.uva.student.calinwouter.ql.interpreter.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.types.TInteger;
import org.uva.student.calinwouter.ql.interpreter.types.TString;

/**
 * This interpreter parses a type production and returns a TypeCallback implementation based on the type.
 */
public class TypeInterpreter extends AnalysisAdapter {

    private TypeDescriptor value;

    @Override
    public void caseABoolType(ABoolType node) {
        setValue(new TypeDescriptor<TBool>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesBoolean();
            }

            @Override
            public TBool getDefaultValue() {
                return new TBool(false);
            }
        });
    }

    @Override
    public void caseAIntType(AIntType node) {
        setValue(new TypeDescriptor<TInteger>() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesInteger();
            }

            @Override
            public TInteger getDefaultValue() {
                return new TInteger(null);
            }
        });
    }

    @Override
    public void caseAStringType(AStringType node) {
        setValue(new TypeDescriptor() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.usesString();
            }

            @Override
            public TString getDefaultValue() {
                return new TString("");
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
