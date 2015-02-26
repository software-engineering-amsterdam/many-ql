package nl.uva.softwcons.validation.dependency.error;

import static nl.uva.softwcons.ast.I18n._i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class CyclicQuestionsDependency extends Error {

    public CyclicQuestionsDependency(final LineInfo lineInfo) {
        super(_i("validation.errors.cyclicdependency", lineInfo.getLine()));
    }

}
