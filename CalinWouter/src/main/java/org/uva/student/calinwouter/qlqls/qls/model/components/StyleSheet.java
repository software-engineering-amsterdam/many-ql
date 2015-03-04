package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class StyleSheet {
    private final String styleSheetName;
    private final Pages pages;
    private final Defaults defaults;

    public StyleSheet(String ident, Page... pages) {
        this(ident, new Pages(pages), new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>()));
    }

    public List<FieldWidget> collectFieldWidgets() {
        return pages.collectFieldWidgets();
    }
}
