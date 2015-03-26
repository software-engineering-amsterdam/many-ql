package nl.uva.softwcons.qls.validation.widget.error;

import static nl.uva.softwcons.ql.i18n.I18n.i;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.validation.Error;

public class IncompatibleWidget extends Error {

    public IncompatibleWidget(LineInfo lineInfo) {
        super(i("validation.errors.qls.incompatiblewidget", lineInfo.getLine(), lineInfo.getPositionInLine()));
    }

}
