package nl.uva.softwcons.validation.typechecker.error;

import static nl.uva.softwcons.ast.I18n.i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class DuplicateQuestionIdentifier extends Error {

    public DuplicateQuestionIdentifier(final LineInfo lineInfo) {
        super(i("validation.errors.duplicateidentifier", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }

}
