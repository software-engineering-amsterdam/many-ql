package org.uva.student.calinwouter.qlqls.ql;

import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Value<?>> variableMap;

    public void setVariable(String ident, Value<?> value){
        variableMap.put(ident, value);
    }

    public Value<?> getVariable(String ident) {
        return variableMap.get(ident);
    }

    public SymbolTable() {
        variableMap = new HashMap<String, Value<?>>();
    }

}
