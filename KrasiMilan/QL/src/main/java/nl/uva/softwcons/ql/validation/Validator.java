package nl.uva.softwcons.ql.validation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.dependency.CyclicDependencyChecker;
import nl.uva.softwcons.ql.validation.identifier.QuestionIdentifierChecker;
import nl.uva.softwcons.ql.validation.label.LabelChecker;
import nl.uva.softwcons.ql.validation.type.TypeChecker;

public final class Validator {
    private Validator() {
    }

    public static List<Error> validate(final Form form) {
        final List<Error> errors = new ArrayList<>();
        errors.addAll(CyclicDependencyChecker.check(form));
        errors.addAll(QuestionIdentifierChecker.check(form));
        errors.addAll(LabelChecker.check(form));
        errors.addAll(TypeChecker.check(form));

        return errors;
    }
}
