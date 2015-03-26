package nl.uva.softwcons.ql.validation.labels.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class DuplicateLabel extends Error { // NOPMD

    public DuplicateLabel(final LineInfo lineInfo) {
        super(i("validation.warnings.duplicatelabel", lineInfo.getLine()));
    }

    @Override
    public boolean isFatal() {
        return false;
    }

    @Override
    public String getMessage() {
        return "Warning: " + super.message;
    }

}
