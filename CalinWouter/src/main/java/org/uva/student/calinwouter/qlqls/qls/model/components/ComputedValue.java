package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQLSRenderer;

import java.util.Map;

public class ComputedValue extends AbstractFormField {

    @Override
    public <T> T applyRenderer(final IQLSRenderer<T> iQLSRenderer) {
        return iQLSRenderer.render(this);
    }

    public ComputedValue(String ident) {
        super(ident);
    }

    public ComputedValue(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}