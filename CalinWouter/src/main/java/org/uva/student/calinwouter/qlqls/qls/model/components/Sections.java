package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.*;

@Data
public class Sections {
    private final List<Section> sections;

    public Sections(Section... sections) {
        this.sections = Arrays.asList(sections);
    }

    protected Map<String, Object> findFieldStylingSettings(final String ident, final TypeDescriptor type) throws FieldNotFoundException {
        for (Section section : sections) {
            if (section.collectFields().contains(ident)) {
                return section.findFieldStylingSettings(ident, type);
            }
        }
        throw new FieldNotFoundException();
    }
}
