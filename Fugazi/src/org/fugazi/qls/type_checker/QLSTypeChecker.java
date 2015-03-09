package org.fugazi.qls.type_checker;

/*
TODO
- no references to questions that are not in the QL program
- all questions of the QL program are placed by the QLS program.
- you cannot place a single question multiple times.
- (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
 */

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;

import java.util.List;

public class QLSTypeChecker {
    private final QLFormDataStorage qlFormData;

    public QLSTypeChecker(QLFormDataStorage _qlFormData) {
        this.qlFormData = _qlFormData;
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */
}
