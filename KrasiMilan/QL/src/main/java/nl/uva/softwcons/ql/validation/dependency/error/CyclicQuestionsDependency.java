package nl.uva.softwcons.ql.validation.dependency.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class CyclicQuestionsDependency extends Error { // NOPMD

    public CyclicQuestionsDependency(final LineInfo lineInfo) {
        super(i("validation.errors.cyclicdependency", lineInfo.getLine()));
    }

}
