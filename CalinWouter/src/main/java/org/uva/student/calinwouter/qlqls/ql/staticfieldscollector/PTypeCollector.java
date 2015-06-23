package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABooleanType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntegerType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.Stack;

public class PTypeCollector extends AnalysisAdapter {
    private final Stack<ITypeDescriptor> typeDescriptors;

    @Override
    public void caseAIntegerType(AIntegerType node) {
        pushType(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseABooleanType(ABooleanType node) {
        pushType(BooleanValue.BOOL_VALUE_TYPE_DESCRIPTOR);
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
