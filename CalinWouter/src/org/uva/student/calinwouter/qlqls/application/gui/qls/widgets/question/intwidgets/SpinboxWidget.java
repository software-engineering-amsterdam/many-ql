package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

public class SpinboxWidget extends TextboxWidget {

    // TODO add intbox specific implementation.
    public SpinboxWidget(Question question, HeadlessFormInterpreter headlessFormInterpreter) {
        super(question, headlessFormInterpreter);
    }
}
