package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.typechecker.PFormTypeChecker;

import java.util.HashSet;
import java.util.Set;

/**
 * reference to undefined questions
 * duplicate question declarations with different types
 * conditions that are not of the type boolean
 * operands of invalid type to operators
 * cyclic dependencies between questions
 * duplicate labels (warning)
 */
public class QLTypeChecker {
    private final AForm aForm;
    private final StaticFields staticFields;

    private void collectDuplicateLabels() {
        Set<String> labels = new HashSet<String>();
        for (AbstractStaticFormField abstractStaticFormField : staticFields) {
            labels.add(abstractStaticFormField.getLabel());
        }
    }

    public TypeCheckResults typeCheck() {
        TypeCheckResults typeCheckResults = new TypeCheckResults();
        PFormTypeChecker formTypeChecker = new PFormTypeChecker(staticFields, typeCheckResults);
        aForm.apply(formTypeChecker);
        return typeCheckResults;
    }

    public QLTypeChecker(AForm aForm, StaticFields staticFields) {
        this.aForm = aForm;
        this.staticFields = staticFields;
    }

    public QLTypeChecker(AForm aForm) {
        this(aForm, new QLStaticAnalyser(aForm).collectStaticFields());
    }

}
