package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

import java.util.HashMap;
import java.util.Map;

public class VariableTypeTable {
    private Map<String, TypeDescriptor> typeMap;

    public void setVariableType(String ident, TypeDescriptor typeDescriptor) {
        typeMap.put(ident, typeDescriptor);
    }

    public TypeDescriptor getVariableType(String ident) {
        return typeMap.get(ident);
    }

    public VariableTypeTable() {
        typeMap = new HashMap<String, TypeDescriptor>();
    }

    public void setIfNotSet(final String text, final TypeDescriptor typeDescriptor) {
        if (typeMap.get(text) == null) {
            typeMap.put(text, typeDescriptor);
        }
    }
}
