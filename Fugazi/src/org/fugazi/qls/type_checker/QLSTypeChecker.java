package org.fugazi.qls.type_checker;

/*
TODO
- no references to questions that are not in the QL program
- all questions of the QL program are placed by the QLS program.
- you cannot place a single question multiple times.
- (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
 */

import org.fugazi.ql.ast.expression.literal.ID;

import java.util.List;

public class QLSTypeChecker {
    private final List<ID> qlQuestions;

    public QLSTypeChecker(List<ID> _qlQuestions) {
        this.qlQuestions = _qlQuestions;
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */
}
