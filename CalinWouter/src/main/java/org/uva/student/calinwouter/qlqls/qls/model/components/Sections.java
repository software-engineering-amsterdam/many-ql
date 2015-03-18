package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;

import java.util.*;

public class Sections implements Iterable<Section> {
    private final List<Section> sections;

    public Sections(Section... sections) {
        this.sections = Arrays.asList(sections);
    }

    @Override
    public Iterator<Section> iterator() {
        return sections.iterator();
    }
}
