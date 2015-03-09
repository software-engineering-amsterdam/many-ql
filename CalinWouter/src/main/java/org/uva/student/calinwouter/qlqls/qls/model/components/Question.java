package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.IRenderable;

import java.util.Map;

public class Question extends AbstractFormField {

    @Override
    public <T> T applyRenderer(final IRenderable<T> iRenderable) throws FieldNotFoundException {
        return iRenderable.render(this);
    }

    public Question(String ident) {
        super(ident);
    }

    public Question(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}
