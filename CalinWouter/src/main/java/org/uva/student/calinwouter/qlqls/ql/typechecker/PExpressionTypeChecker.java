package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.QLTypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.uva.student.calinwouter.qlqls.ql.helper.ASTHelper.*;

/**
 * This type checker works by pushing elements on the stack, and assessing the type of the value that is popped
 * from the stack. When the type popped from the stack is not the same as (one of) the allowed types, the type checker
 * will add an error to the list of type check results.
 */
public class PExpressionTypeChecker extends ReversedDepthFirstAdapter {
    private final StaticFields staticFields;
    private final Stack<ITypeDescriptor> typeDescriptors;
    private final QLTypeCheckResults QLTypeCheckResults;
    private final Map<String, List<String>> variableDependencies;
    private String lastComputedValueIdentifier;

    @Override
    public void outAAddExpression(AAddExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseASubtractExpression(ASubtractExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseATrueExpression(ATrueExpression node) {
        pushBoolean();
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node) {
        pushBoolean();
    }

    @Override
    public void caseAOrExpression(AOrExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAAndExpression(AAndExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popBoolean();
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseAEqualsExpression(AEqualsExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseANotEqualsExpression(ANotEqualsExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popType();
        popType();
        pushBoolean();
    }

    @Override
    public void caseALesserThanExpression(ALesserThanExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGreaterThanExpression(AGreaterThanExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseALesserThanOrEqualsExpression(ALesserThanOrEqualsExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushBoolean();
    }

    @Override
    public void caseAGreaterThanOrEqualsExpression(AGreaterThanOrEqualsExpression node) {
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
    public void caseAMultiplyExpression(AMultiplyExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseADivideExpression(ADivideExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseAModuloExpression(AModuloExpression node) {
        typeCheckExpression(node.getLeft());
        typeCheckExpression(node.getRight());
        popInteger();
        popInteger();
        pushInteger();
    }

    @Override
    public void caseANotExpression(ANotExpression node) {
        typeCheckExpression(node.getExpression());
        popBoolean();
        pushBoolean();
    }

    @Override
    public void caseANumberExpression(ANumberExpression node) {
        pushInteger();
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node) {
        final String variableName = getIdentifier(node);
        checkUndefinedReference(variableName);
        checkIfComputedValueDependency(variableName);
        pushIdentifierType(variableName);
    }

    public void typeCheckExpression(PExpression expression){
        expression.apply(this);
    }

    private void checkUndefinedReference(String identifier) {
        if (!staticFields.containsField(identifier)) {
            addErrorUndefinedReference(identifier);
        }
    }

    private void checkIfComputedValueDependency(String identifier){
        if (lastComputedValueIdentifier != null){
            variableDependencies.get(lastComputedValueIdentifier).add(identifier);
        }
    }

    public void setLastComputedValueIdentifier(String identifier){
        lastComputedValueIdentifier = identifier;
    }

    public ITypeDescriptor popType() {
        return typeDescriptors.pop();
    }

    private void addErrorUndefinedReference(String variableName) {
        QLTypeCheckResults.addUndefinedReferenceError(variableName);
    }

    private void pushType(ITypeDescriptor typeDescriptor) {
        typeDescriptors.push(typeDescriptor);
    }

    private void checkPopGeneratesNoTypeError(ITypeDescriptor assertedType) {
        final ITypeDescriptor lastStackElement = popType();
        if (!lastStackElement.equals(assertedType)) {
            QLTypeCheckResults.addErrorTypeIsNotOfType(assertedType);
        }
    }

    private void popBoolean() {
        checkPopGeneratesNoTypeError(BooleanValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    private void popInteger() {
        checkPopGeneratesNoTypeError(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushInteger() {
        pushType(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
    }

    private void pushBoolean() {
        pushType(BooleanValue.BOOL_VALUE_TYPE_DESCRIPTOR);
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
            QLTypeCheckResults.addErrorTypeIsNotOfType(typeDescriptor);
        }
    }

    public PExpressionTypeChecker(StaticFields staticFields, QLTypeCheckResults QLTypeCheckResults, Map<String, List<String>> variableDependencies) {
        this.staticFields = staticFields;
        this.typeDescriptors = new Stack<ITypeDescriptor>();
        this.QLTypeCheckResults = QLTypeCheckResults;
        this.variableDependencies = variableDependencies;
    }
}
