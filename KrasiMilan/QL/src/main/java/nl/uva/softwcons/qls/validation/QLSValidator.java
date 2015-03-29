package nl.uva.softwcons.qls.validation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.validation.questionidentifier.QuestionIdentifierChecker;
import nl.uva.softwcons.qls.validation.widget.WidgetTypeChecker;

public final class QLSValidator {
    private QLSValidator() {
    }

    public static List<Error> validate(Form form, Stylesheet stylesheet) {
        List<Error> qlsErrors = new ArrayList<Error>();
        qlsErrors.addAll(QuestionIdentifierChecker.check(stylesheet, form));
        qlsErrors.addAll(WidgetTypeChecker.check(stylesheet, form));

        return qlsErrors;

    }

}
