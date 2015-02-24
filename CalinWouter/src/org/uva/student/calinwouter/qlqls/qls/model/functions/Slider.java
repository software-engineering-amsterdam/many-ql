package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

public class Slider extends AbstractComponent<Slider> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseSlider(this);
    }

}
