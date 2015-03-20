package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.node.AStylesheetBegin;
import org.uva.student.calinwouter.qlqls.qls.exceptions.CouldNotFindMatchingQLSComponentException;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

/**
 * QLS interpretation basically means converting the abstract syntax tree into an internal QLS model.
 */
public class QLSInterpreter {

    /**
     * Transform the AST into a QLS model.
     */
    public StyleSheet interpret(AStylesheetBegin aStylesheetBegin) throws CouldNotFindMatchingQLSComponentException {
        final QLSAdapter qlsAdapter = new QLSAdapter();
        aStylesheetBegin.apply(qlsAdapter);
        return (StyleSheet) qlsAdapter.popValue();
    }

}
