package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.IQlsRenderer;

import java.util.Map;

public class ComputedValue extends AbstractFormField {

    @Override
    public <T> T applyRenderer(final IQlsRenderer<T> iQlsRenderer) throws FieldNotFoundException {
        return iQlsRenderer.render(this);
    }

    public ComputedValue(String ident) {
        super(ident);
    }

    public ComputedValue(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}