package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class Page {
    private final String ident;
    private final Sections sections;
    private final Defaults defaults;

    public Page(String ident, Section... sections) {
        this(ident, new Sections(sections), null);
    }

    public Collection<FieldWidget> collectFieldWidgets() {
        return sections.collectFieldWidgets();
    }
}
