package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.node.AStylesheetBegin;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractPushable;
import org.uva.student.calinwouter.qlqls.qls.model.StyleSheetResultsEnvironment;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This typechecker for QLS allows the user to:
 *
 * - Detect unallowed widget types (e.g. textbox for boolean fields);
 * - Detect unallowed field references from QLS to QL;
 * - Get a list of unreferenced fields from a specified list of allowable references;
 * - Detect fields used multiple times.
 */
public class QLSTypeChecker {

    public StyleSheetResultsEnvironment typeCheck(AStylesheetBegin aStylesheetBegin) {
        QLSAdapter qlsAdapter = new QLSAdapter();
        aStylesheetBegin.apply(qlsAdapter);
        return (StyleSheet) qlsAdapter.getValue();
    }

}