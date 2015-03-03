package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.node.AStylesheetBegin;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

public class QLSInterpreter {

    public StyleSheet interpret(AStylesheetBegin aStylesheetBegin) {
        QLSAdapter qlsAdapter = new QLSAdapter();
        aStylesheetBegin.apply(qlsAdapter);
        return (StyleSheet) qlsAdapter.getValue();
    }

}
