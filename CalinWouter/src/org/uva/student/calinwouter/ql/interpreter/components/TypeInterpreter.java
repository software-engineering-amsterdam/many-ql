package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.node.ABoolType;
import org.uva.student.calinwouter.ql.generated.node.AIntType;
import org.uva.student.calinwouter.ql.generated.node.AStringType;

public class TypeInterpreter extends AnalysisAdapter {

    private TypeDescriptor value;

    @Override
    public void caseABoolType(ABoolType node) {
        setValue(new TypeDescriptor() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.callbackBoolean();
            }
        });
    }

    @Override
    public void caseAIntType(AIntType node) {
        setValue(new TypeDescriptor() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.callbackInteger();
            }
        });
    }

    @Override
    public void caseAStringType(AStringType node) {
        setValue(new TypeDescriptor() {
            @Override
            public void callTypeMethod(TypeCallback typeCallback) {
                typeCallback.callbackString();
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
