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

/**
 * This type checker works by pushing elements on the stack, and assessing the type of the value that is popped
 * from the stack. When the type popped from the stack is not the same as (one of) the allowed types, the typechecker
 * will add an error to the list of type check results.
 */
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
    public void caseAStringElement(AStringElement node) {
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
        final String variableName = getIdentifier(node);
        addErrorIfNotReferenced(variableName);
        pushAndCheckIdentifierType(variableName);
    }

    public TypeDescriptor popType() {
        return typeDescriptors.pop();
    }

    private static String getIdentifier(AIdentExp node) {
        final TIdent identifierInAst = node.getIdent();
        return identifierInAst.getText();
    }

    private void addErrorIfNotReferenced(String variableName) {
        if (!staticFields.containsField(variableName)) {
            typeCheckResults.addUndefinedReferenceError(variableName);
        }
    }

    private void pushType(TypeDescriptor typeDescriptor) {
        typeDescriptors.push(typeDescriptor);
    }

    private void checkPopGeneratesNoTypeError(TypeDescriptor assertedType) {
        final TypeDescriptor lastStackElement = popType();
        if (!lastStackElement.equals(assertedType)) {
            typeCheckResults.addErrorTypeIsNotOfType(assertedType);
        }
    }

    private void popBoolean() {
        checkPopGeneratesNoTypeError(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }
    
    private void popInteger() {
        checkPopGeneratesNoTypeError(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
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

    private boolean isDeclared(String identifier) {
        return getTypeOfField(identifier) != null;
    }

    private TypeDescriptor getTypeOfField(String identifier) {
        return staticFields.getTypeOfField(identifier);
    }

    private void addErrorIfNotDeclared(String identifier) {
        if (!isDeclared(identifier)) {
            typeCheckResults.addNotDeclaredError(identifier);
        }
    }

    private void pushIdentifierType(String identifier) {
        final TypeDescriptor fieldType = getTypeOfField(identifier);
        pushType(fieldType);
    }

    private void pushAndCheckIdentifierType(String identifier) {
        addErrorIfNotDeclared(identifier);
        pushIdentifierType(identifier);
    }

    public void checkLastEntryIsOfType(final TypeDescriptor typeDescriptor) {
        assert(typeDescriptors.size() == 1);
        if (!popType().equals(typeDescriptor)) {
            typeCheckResults.addErrorTypeIsNotOfType(typeDescriptor);
        }
    }

    public PExpTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.typeDescriptors = new Stack<TypeDescriptor>();
        this.typeCheckResults = typeCheckResults;
    }
}
