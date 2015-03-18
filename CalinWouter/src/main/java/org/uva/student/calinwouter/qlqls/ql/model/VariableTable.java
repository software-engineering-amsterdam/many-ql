package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.Map;

public class VariableTable {
    private Map<String, Value> variableMap;

    public boolean isSet(String identifer) {
        return variableMap.get(identifer) != null;
    }

    public void setVariable(String identifer, Value value) {
        variableMap.put(identifer, value);
    }

    public Value getVariable(String identifer) {
        return variableMap.get(identifer);
    }

    public VariableTable() {
        variableMap = new HashMap<String, Value>();
    }
}
