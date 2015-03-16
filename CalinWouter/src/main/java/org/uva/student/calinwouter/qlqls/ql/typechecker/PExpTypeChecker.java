package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.Stack;

public class PExpTypeChecker extends ReversedDepthFirstAdapter {
    private final StaticFields staticFields;
    private final Stack<TypeDescriptor> typeDescriptors;
    private final TypeCheckResults typeCheckResults;

    @Override
    public void outAAddExp(AAddExp node) {
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseASubExp(ASubExp node) {
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        pushBoolean();
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        pushBoolean();
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseALtExp(ALtExp node) {
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseALteExp(ALteExp node) {
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAStringElement(final AStringElement node) {
        pushString();
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseADivExp(ADivExp node) {
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseAModExp(AModExp node) {
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseANotExp(ANotExp node) {
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        pushInteger();
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        String variableName = node.getIdent().getText();
        if (!staticFields.containsField(variableName)) {
            typeCheckResults.addError("Undefined reference.");
        }
        pushIdentifierType(variableName);
    }

    public TypeDescriptor popType() {
        return typeDescriptors.pop();
    }

    private void pushType(TypeDescriptor typeDescriptor) {
        typeDescriptors.push(typeDescriptor);
    }

    private void addError(String error) {
        typeCheckResults.addError(error);
    }

    private void popBoolean() {
        if (!popType().equals(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR)) {
            addError("Type is not of type " + BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR + ".");
        }
    }
    
    private void popInteger() {
        if (!popType().equals(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR)) {
            addError("Type is not of type " + IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR + ".");
        }
    }
    
    private void pushInteger() {
        pushType(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushBoolean() {
        pushType(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushString() {
        pushType(StringValue.STRING_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushIdentifierType(String ident) {
        final TypeDescriptor typeDescriptor = staticFields.getTypeOfField(ident);
        if (typeDescriptor == null) {
            addError(ident + " is not declared.");
        }
        pushType(typeDescriptor);
    }

    public PExpTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.typeDescriptors = new Stack<TypeDescriptor>();
        this.typeCheckResults = typeCheckResults;
    }

    public void checkLastEntryIsOfType(final TypeDescriptor typeDescriptor) {
        assert(typeDescriptors.size() == 1);
        if (!popType().equals(typeDescriptor)) {
            addError("Type is not of type " + typeDescriptor + ".");
        }
    }
}
