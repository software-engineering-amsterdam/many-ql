package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.Map;

@Data
@AllArgsConstructor
public class Page {
    private final String ident;
    private final Sections sections;
    private final Defaults defaults;

    public Page(String ident, Section... sections) {
        this(ident, new Sections(sections), null);
    }
    protected Map<String, Object> findFieldStylingSettings(final String ident, final TypeDescriptor type) throws FieldNotFoundException {
        return defaults.createNewStylingSettingsMapUsingOverriding(type, sections.findFieldStylingSettings(ident, type));
    }
}
