package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;
import org.uva.student.calinwouter.qlqls.qls.model.functions.*;

import java.awt.*;

public class QLSGUI extends AbstractSwingGUI {
    private final QLSRenderParameters qlsRenderParameters;
    private final StyleSheet styleSheet;

    @Override
    public Component renderFrameContent() {
        return styleSheet.render(qlsRenderParameters);
    }

    @Override
    protected String getFrameTitle() {
        return styleSheet.getStyleSheetName();
    }

    public QLSGUI(StyleSheet styleSheet, QLInterpreter qlInterpreter, VariableTable variableTable,
                  StaticFields staticFields) {
        final StateWrapper stateWrapper = new StateWrapper(variableTable);
        this.styleSheet = styleSheet;
        this.qlsRenderParameters = new QLSRenderParameters(qlInterpreter, stateWrapper, staticFields, styleSheet);
    }
}
