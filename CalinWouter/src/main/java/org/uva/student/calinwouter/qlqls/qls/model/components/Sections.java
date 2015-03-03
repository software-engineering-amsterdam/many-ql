package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
public class Sections extends LinkedList<Section> {
    private final List<Section> sections;

    public Sections(Section... sections) {
        this.sections = Arrays.asList(sections);
    }

    public Collection<FieldWidget> collectFieldWidgets() {
        List<FieldWidget> fieldWidgets = new LinkedList<FieldWidget>();
        for (Section section : sections) {
            fieldWidgets.addAll(section.collectFieldWidgets());
        }
        return fieldWidgets;
    }
}
