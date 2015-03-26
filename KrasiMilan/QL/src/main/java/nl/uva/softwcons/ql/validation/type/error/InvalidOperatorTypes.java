package nl.uva.softwcons.ql.validation.type.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class InvalidOperatorTypes extends Error { // NOPMD

    public InvalidOperatorTypes(final LineInfo lineInfo) {
        super(i("validation.errors.invalidoperatortypes", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }
}
