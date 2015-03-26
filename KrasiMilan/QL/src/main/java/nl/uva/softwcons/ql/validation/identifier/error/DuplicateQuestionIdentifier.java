package nl.uva.softwcons.ql.validation.identifier.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class DuplicateQuestionIdentifier extends Error { // NOPMD

    public DuplicateQuestionIdentifier(final LineInfo lineInfo) {
        super(i("validation.errors.duplicateidentifier", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }

}
