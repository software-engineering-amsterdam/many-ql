package nl.uva.softwcons.ql.validation.typechecker.error;

import static nl.uva.softwcons.ql.ast.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class InvalidConditionType extends Error { // NOPMD

    public InvalidConditionType(final LineInfo lineInfo) {
        super(i("validation.errors.invalidconditiontype", lineInfo.getLine()));
    }

}
