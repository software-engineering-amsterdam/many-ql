package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.Stack;

public class PTypeCollector extends AnalysisAdapter {
    private final Stack<ITypeDescriptor> typeDescriptors;

    @Override
    public void caseAIntType(AIntType node) {
        pushType(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseABoolType(ABoolType node) {
        pushType(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseAStringType(AStringType node) {
        pushType(StringValue.STRING_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushType(ITypeDescriptor typeDescriptor) {
        typeDescriptors.push(typeDescriptor);
    }

    public ITypeDescriptor popType() {
        return typeDescriptors.pop();
    }

    public PTypeCollector() {
        this.typeDescriptors = new Stack<ITypeDescriptor>();
    }
}
