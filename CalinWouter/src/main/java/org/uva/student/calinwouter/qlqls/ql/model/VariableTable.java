package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.Map;

public class VariableTable {
    private Map<String, Value> variableMap;

    public boolean isSet(String ident) {
        return variableMap.get(ident) != null;
    }

    public void setVariable(String ident, Value value) {
        variableMap.put(ident, value);
    }

    public Value getVariable(String ident) {
        return variableMap.get(ident);
    }

    public VariableTable() {
        variableMap = new HashMap<String, Value>();
    }

    public void setIfNotSet(final String text, final Value value) {
        if (variableMap.get(text) == null) {
            variableMap.put(text, value);
        }
    }
}
