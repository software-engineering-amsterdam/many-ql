package nl.uva.softwcons.qls.validation.questionidentifier.error;

import static nl.uva.softwcons.ql.ast.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class UnknownQuestionIdentifier extends Error { // NOPMD

    public UnknownQuestionIdentifier(final LineInfo lineInfo) {
        super(i("validation.errors.qls.unknownidentifier", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }

}
