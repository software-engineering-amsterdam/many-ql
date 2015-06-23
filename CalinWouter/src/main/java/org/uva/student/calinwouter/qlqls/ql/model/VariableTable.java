package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.Map;

public class VariableTable {
    private Map<String, Value> variableMap;

    public boolean isSet(String identifier) {
        return variableMap.get(identifier) != null;
    }

    public void setVariable(String identifier, Value value) {
        variableMap.put(identifier, value);
    }

    public Value getVariable(String identifier) {
        return variableMap.get(identifier);
    }

    public VariableTable() {
        variableMap = new HashMap<String, Value>();
    }
}
