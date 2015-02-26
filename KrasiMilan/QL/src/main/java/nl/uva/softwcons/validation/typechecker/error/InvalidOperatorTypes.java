package nl.uva.softwcons.validation.typechecker.error;

import static nl.uva.softwcons.ast.i18n._i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class InvalidOperatorTypes extends Error {

    public InvalidOperatorTypes(final LineInfo lineInfo) {
        super(_i("validation.errors.invalidoperatortypes", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }
}
