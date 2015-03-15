package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.ABoolType;
import org.uva.student.calinwouter.qlqls.generated.node.AIntType;
import org.uva.student.calinwouter.qlqls.generated.node.AStringType;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.Stack;

/**
 * This ql parses a type production and returns a TypeCallback implementation based on the type.
 */
public class PTypeInterpreter extends AnalysisAdapter {

    private final Stack<TypeDescriptor> typeDescriptorStack;

    @Override
    public void caseABoolType(final ABoolType node) {
        pushValue(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseAIntType(final AIntType node) {
        pushValue(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    @Override
    public void caseAStringType(final AStringType node) {
        pushValue(StringValue.STRING_VALUE_TYPE_DESCRIPTOR);
    }

    public void pushValue(TypeDescriptor typeDescriptor) {
        typeDescriptorStack.push(typeDescriptor);
    }

    public TypeDescriptor popValue() {
        return typeDescriptorStack.pop();
    }

    public PTypeInterpreter() {
        this.typeDescriptorStack = new Stack<TypeDescriptor>();
    }

}
