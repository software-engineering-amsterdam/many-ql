package org.uva.student.calinwouter.ql.interpreter.model;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Object> varToVal;

    public HashMap<String, Object> getEnvVars() { return varToVal; }

    public Environment() {
        varToVal = new HashMap<String, Object>();
    }
}
