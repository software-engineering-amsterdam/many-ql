package org.uva.student.calinwouter.qlqls.qls.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public abstract class AbstractFormField {
    protected final String ident;
    protected final Map<String, Object> stylingArguments;

    public AbstractFormField(String ident) {
        this(ident, new HashMap<String, Object>());
    }

    public FieldWidget collectFieldWidget() {
        return new FieldWidget(ident, (AbstractWidget) stylingArguments.get("widget"));
    }
}
