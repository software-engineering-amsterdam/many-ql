package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
public class Pages {
    private final List<Page> pages;

    public Pages(Page... pages) {
        this.pages = Arrays.asList(pages);
    }

    protected Map<String, Object> findFieldStylingSettings(final String ident, final TypeDescriptor type) throws FieldNotFoundException {
        for (Page page : pages) {
            if (page.collectFields().contains(ident)) {
                return page.findFieldStylingSettings(ident, type);
            }
        }
        throw new FieldNotFoundException();
    }
}
