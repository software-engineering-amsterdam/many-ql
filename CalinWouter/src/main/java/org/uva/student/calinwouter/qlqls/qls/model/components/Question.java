package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQLSRenderer;

import java.util.Map;

public class Question extends AbstractFormField {

    @Override
    public <T> T applyRenderer(final IQLSRenderer<T> iQlsRenderer) {
        return iQlsRenderer.render(this);
    }

    public Question(String ident) {
        super(ident);
    }

    public Question(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}
