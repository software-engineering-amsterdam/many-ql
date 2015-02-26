package nl.uva.softwcons.validation.typechecker.error;

import static nl.uva.softwcons.ast.I18n._i;
import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.validation.Error;

public class InvalidQuestionExpressionType extends Error {

    public InvalidQuestionExpressionType(final LineInfo lineInfo) {
        super(_i("validation.errors.invalidquestionexpressiontype", lineInfo.getLine()));
    }

}
