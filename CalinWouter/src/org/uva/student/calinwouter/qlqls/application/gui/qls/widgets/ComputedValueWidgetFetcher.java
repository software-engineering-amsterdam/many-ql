package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.functions.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IComputedValueWidgetCallback;

import java.awt.*;

public class ComputedValueWidgetFetcher implements IComputedValueWidgetCallback, IWidget {
    private IWidget widget;
    private HeadlessFormInterpreter headlessFormInterpreter;

    @Override
    public void caseLabelWidget(ComputedValue computedValue) {
         widget = new LabelWithWidgetWidget(computedValue,
                new LabelWidget(computedValue, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }

    public ComputedValueWidgetFetcher(HeadlessFormInterpreter headlessFormInterpreter) {
        this.headlessFormInterpreter = headlessFormInterpreter;
    }
}
