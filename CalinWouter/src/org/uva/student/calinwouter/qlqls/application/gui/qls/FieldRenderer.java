package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.qls.model.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.Question;

import java.awt.*;

public class FieldRenderer extends AbstractRenderer {
    private Component fieldComponent;

    public Component getFieldComponent() {
        return fieldComponent;
    }

    @Override
    public void caseQuestion(Question question) {

        super.caseQuestion(question);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        super.caseComputedValue(computedValue);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
