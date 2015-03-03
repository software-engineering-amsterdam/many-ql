package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IComputedValueWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.HashMap;

public class ComputedValue extends AbstractFormField<ComputedValue> {

    public void applyWidget(IComputedValueWidgetCallback widgetCallback) {
        // Currently, there is no syntax to add different widgets than the label widget.
        widgetCallback.caseLabelWidget(this);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseComputedValue(this);
    }

    public ComputedValue() {
        stylingArguments = new HashMap<String, Object>();
    }
}