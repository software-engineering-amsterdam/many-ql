package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

import java.util.Map;

@Data
public class Defaults {
    private final Map<ITypeDescriptor, Map<String, Object>> defaultStyleSheetSettings;

    public Defaults(Map defaultStyleSheetSettings) {
        this.defaultStyleSheetSettings = (Map<ITypeDescriptor, Map<String, Object>>)
                defaultStyleSheetSettings;
    }
}
