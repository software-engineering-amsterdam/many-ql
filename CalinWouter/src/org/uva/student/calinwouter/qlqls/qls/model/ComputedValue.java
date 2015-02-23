package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;

import java.util.HashMap;
import java.util.List;

public class ComputedValue extends AbstractFormField<ComputedValue> {

    public void applyWidget(IComputedValueWidgetCallback widgetCallback) {
        // TODO
    }

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        value = headlessFormInterpreter.getField(ident);

        visible = false;
        List<FormField> fields = headlessFormInterpreter.getFields();
        for (FormField field : fields) {
            if(field.getVariable().equals(ident))
                visible = true;
        }

        notifyUpdate();
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseComputedValue(this);
    }

    public ComputedValue(){
        arguments = new HashMap<Object, Object>();
        visible = false;
    }
}