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
 * reference to undefined questions
 * X duplicate question declarations with different types
 * X conditions that are not of the type boolean
 * X operands of invalid type to operators
 * cyclic dependencies between questions
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
                typeCheckResults.addWarning("Label " + fieldLabel + " found twice.");
            }
        }
    }

    // TODO refactor
    private void collectDuplicateQuestionsWithDifferentTypes() {
        Map<String, TypeDescriptor> identToTypeMap = new HashMap<String, TypeDescriptor>();
        for (AbstractStaticFormField abstractStaticFormField : staticFields) {
            if (!identToTypeMap.containsKey(abstractStaticFormField.getVariable())) {
                identToTypeMap.put(
                        abstractStaticFormField.getVariable(),
                        abstractStaticFormField.getTypeDescriptor());
            }
            if (!identToTypeMap.get(abstractStaticFormField.getVariable())
                    .equals(abstractStaticFormField.getTypeDescriptor())) {
                typeCheckResults.addError("Two questions with the same identifier and a different type for label: "
                        + abstractStaticFormField.getVariable());
            }
        }
    }

    private void checkInvalidOperands() {
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFields, typeCheckResults);
        aForm.apply(formTypeChecker);
    }

    public TypeCheckResults typeCheck() {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        collectDuplicateQuestionsWithDifferentTypes();
        collectDuplicateLabels();
        checkInvalidOperands();
        return typeCheckResults;
    }

    public QLTypeChecker(AForm aForm, StaticFields staticFields) {
        this.aForm = aForm;
        this.staticFields = staticFields;
        this.typeCheckResults = new TypeCheckResults();
    }

    public QLTypeChecker(AForm aForm) {
        this(aForm, new QLStaticAnalyser(aForm).collectStaticFields());
    }

}
