package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

public class QLSRenderParameters {
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private final StaticFields staticFields;
    private final StyleSheet styleSheet;

    public QLSRenderParameters(QLInterpreter qlInterpreter, StateWrapper stateWrapper, StaticFields staticFields, StyleSheet styleSheet) {
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.staticFields = staticFields;
        this.styleSheet = styleSheet;
    }

    public QLInterpreter getQlInterpreter() {
        return qlInterpreter;
    }

    public StateWrapper getStateWrapper() {
        return stateWrapper;
    }

    public StaticFields getStaticFields() {
        return staticFields;
    }

    public StyleSheet getStyleSheet() {
        return styleSheet;
    }
}
