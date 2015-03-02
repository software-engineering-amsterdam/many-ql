package nl.uva.softwcons.validation.typechecker.error;

import static nl.uva.softwcons.ast.I18n.i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class InvalidConditionType extends Error {

    public InvalidConditionType(final LineInfo lineInfo) {
        super(i("validation.errors.invalidconditiontype", lineInfo.getLine()));
    }

}
