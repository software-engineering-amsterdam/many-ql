package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * This type checker works by pushing elements on the stack, and assessing the type of the value that is popped
 * from the stack. When the type popped from the stack is not the same as (one of) the allowed types, the typechecker
 * will add an error to the list of type check results.
 */
public class PExpTypeChecker extends ReversedDepthFirstAdapter {
    private final StaticFields staticFields;
    private final Stack<ITypeDescriptor> typeDescriptors;
    private final TypeCheckResults typeCheckResults;
    private final Map<String, List<String>> variableDependencies;
    private String lastComputedValueIdentifier;

    @Override
    public void outAAddExp(AAddExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseASubExp(ASubExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
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
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseALtExp(ALtExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseALteExp(ALteExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
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
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseADivExp(ADivExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseAModExp(AModExp node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseANotExp(ANotExp node) {
        typeCheckExpression(node.getExp());
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
        checkUndefinedReference(variableName);
        checkIfComputedValueDependency(variableName);
        pushIdentifierType(variableName);
    }

    public void typeCheckExpression(PExp exp){
        exp.apply(this);
    }

    private void checkUndefinedReference(String identifier){
        if(!staticFields.containsField(identifier))
            addErrorUndefinedReference(identifier);
    }

    private void checkIfComputedValueDependency(String identifier){
        if(lastComputedValueIdentifier != null){
            variableDependencies.get(lastComputedValueIdentifier).add(identifier);
        }
    }

    public void setLastComputedValueIdentifier(String identifier){
        lastComputedValueIdentifier = identifier;
    }

    public ITypeDescriptor popType() {
        return typeDescriptors.pop();
    }

    private static String getIdentifier(AIdentExp node) {
        final TIdent identifierInAst = node.getIdent();
        return identifierInAst.getText();
    }

    private void addErrorUndefinedReference(String variableName) {
        typeCheckResults.addUndefinedReferenceError(variableName);
    }

    private void pushType(ITypeDescriptor typeDescriptor) {
        typeDescriptors.push(typeDescriptor);
    }

    private void checkPopGeneratesNoTypeError(ITypeDescriptor assertedType) {
        final ITypeDescriptor lastStackElement = popType();
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

    private ITypeDescriptor getTypeOfField(String identifier) {
        ITypeDescriptor fieldType;
        try {
            fieldType =  staticFields.getTypeOfField(identifier);
        } catch (FieldNotFoundException e) {
            fieldType = new UndefinedTypeDescriptor();
        }
        return fieldType;
    }

    private void pushIdentifierType(String identifier) {
        final ITypeDescriptor fieldType = getTypeOfField(identifier);
        pushType(fieldType);
    }


    public void checkLastEntryIsOfType(final ITypeDescriptor typeDescriptor) {
        assert(typeDescriptors.size() == 1);
        if (!popType().equals(typeDescriptor)) {
            typeCheckResults.addErrorTypeIsNotOfType(typeDescriptor);
        }
    }

    public PExpTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults, Map<String , List<String>> variableDependencies) {
        this.staticFields = staticFields;
        this.typeDescriptors = new Stack<ITypeDescriptor>();
        this.typeCheckResults = typeCheckResults;
        this.variableDependencies = variableDependencies;
    }
}
