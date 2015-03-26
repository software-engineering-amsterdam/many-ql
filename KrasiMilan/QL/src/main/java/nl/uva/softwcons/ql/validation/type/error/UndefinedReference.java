package nl.uva.softwcons.ql.validation.type.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class UndefinedReference extends Error { // NOPMD

    public UndefinedReference(final LineInfo lineInfo) {
        super(i("validation.errors.undefinedreference", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }

}
