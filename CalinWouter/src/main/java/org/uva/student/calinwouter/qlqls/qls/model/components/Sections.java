package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;

import java.util.*;

@Data
public class Sections {
    private final List<Section> sections;

    public Sections(Section... sections) {
        this.sections = Arrays.asList(sections);
    }

}
