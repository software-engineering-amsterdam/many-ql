package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
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
 * X reference to undefined questions
 * X duplicate question declarations with different types
 * X conditions that are not of the type boolean
 * X operands of invalid type to operators
 *   cyclic dependencies between questions
 * X duplicate labels (warning)
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

    private void checkSameType(Map<String, TypeDescriptor> identifierToTypeMap, AbstractStaticFormField toCheck) {
        final String toCheckVariable = toCheck.getVariable();
        final TypeDescriptor earlierFoundValueType = identifierToTypeMap.get(toCheckVariable);
        final TypeDescriptor toCheckType = toCheck.getTypeDescriptor();
        if (!earlierFoundValueType.equals(toCheckType)) {
            typeCheckResults.addTwoQuestionsSameTypeError(toCheckVariable);
        }
    }

    private void putIfNotSet(Map<String, TypeDescriptor> identifierToTypeMap, AbstractStaticFormField toPut) {
        final String variableToPut = toPut.getVariable();
        final TypeDescriptor variableType = toPut.getTypeDescriptor();
        if (!identifierToTypeMap.containsKey(variableToPut)) {
            identifierToTypeMap.put(variableToPut, variableType);
        }
    }

    private void collectDuplicateQuestionsWithDifferentTypes() {
        Map<String, TypeDescriptor> identifierToTypeMap = new HashMap<String, TypeDescriptor>();
        for (AbstractStaticFormField abstractStaticFormField : staticFields) {
            putIfNotSet(identifierToTypeMap, abstractStaticFormField);
            checkSameType(identifierToTypeMap, abstractStaticFormField);
        }
    }

    /**
     * Go through the AST to collect type errors that require additional in-depth analysis.
     */
    private void collectTypeCheckErrorsInDepth() {
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFields, typeCheckResults);
        aForm.apply(formTypeChecker);
    }

    public TypeCheckResults typeCheck() {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
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
