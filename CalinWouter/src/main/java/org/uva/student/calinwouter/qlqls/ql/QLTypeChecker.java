package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This type checker checks:
 *
 * Reference to undefined questions
 * Duplicate question declarations with different types
 * Conditions that are not of the type boolean
 * Operands of invalid type to operators
 * Cyclic dependencies between questions
 * Duplicate labels (warning)
 */
public class QLTypeChecker {
    private final AForm aForm;
    private final StaticFields staticFields;
    private final TypeCheckResults typeCheckResults;

    private void collectDuplicateLabels() {
        Set<String> labels = new HashSet<String>();
        for (AbstractStaticFormField abstractStaticFormField : staticFields) {
            final String fieldLabel = abstractStaticFormField.getLabel();
            if (!labels.add(fieldLabel)) {
                typeCheckResults.addLabelFoundTwiceWarning(fieldLabel);
            }
        }
    }

    private void checkSameType(Map<String, ITypeDescriptor> identifierToTypeMap, AbstractStaticFormField toCheck) {
        final String toCheckVariable = toCheck.getVariable();
        final ITypeDescriptor earlierFoundValueType = identifierToTypeMap.get(toCheckVariable);
        final ITypeDescriptor toCheckType = toCheck.getTypeDescriptor();
        if (!earlierFoundValueType.equals(toCheckType)) {
            typeCheckResults.addTwoQuestionsSameTypeError(toCheckVariable);
        }
    }

    private void putIfNotSet(Map<String, ITypeDescriptor> identifierToTypeMap, AbstractStaticFormField toPut) {
        final String variableToPut = toPut.getVariable();
        final ITypeDescriptor variableType = toPut.getTypeDescriptor();
        if (!identifierToTypeMap.containsKey(variableToPut)) {
            identifierToTypeMap.put(variableToPut, variableType);
        }
    }

    private void collectDuplicateQuestionsWithDifferentTypes() {
        Map<String, ITypeDescriptor> identifierToTypeMap = new HashMap<String, ITypeDescriptor>();
        for (AbstractStaticFormField abstractStaticFormField : staticFields) {
            putIfNotSet(identifierToTypeMap, abstractStaticFormField);
            checkSameType(identifierToTypeMap, abstractStaticFormField);
        }
    }

    private void collectTypeCheckErrorsInDepth() {
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFields, typeCheckResults);
        aForm.apply(formTypeChecker);
    }

    public TypeCheckResults typeCheck() {
        collectDuplicateQuestionsWithDifferentTypes();
        collectDuplicateLabels();
        collectTypeCheckErrorsInDepth();
        return typeCheckResults;
    }

    public QLTypeChecker(AForm aForm, StaticFields staticFields) {
        this.aForm = aForm;
        this.staticFields = staticFields;
        this.typeCheckResults = new TypeCheckResults();
    }

    private static StaticFields collectStaticFields(AForm aForm) {
        return new QLStaticAnalyser(aForm).collectStaticFields();
    }

    public QLTypeChecker(AForm aForm) {
        this(aForm, collectStaticFields(aForm));
    }

}
