package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;

import java.awt.*;

// TODO ...
public class QLGUI extends AbstractSwingGUI {

    private final FormInterpreter headlessformInterpreter;

    @Override
    protected String getFrameTitle() {
        return "QL Viewer";
    }

    @Override
    protected Component renderFrameContent() {
        for (FormField f : headlessformInterpreter.getFields()) {
            // TODO
        }
        return null; // TODO
    }

    public QLGUI(FormInterpreter headlessformInterpreter) {
        this.headlessformInterpreter = headlessformInterpreter;
    }

}
