package nl.uva.softwcons.validation.labels.error;

import static nl.uva.softwcons.ast.i18n._i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class DuplicateLabel extends Error {

    public DuplicateLabel(final LineInfo lineInfo) {
        super(_i("validation.warnings.duplicatelabel", lineInfo.getLine()));
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
