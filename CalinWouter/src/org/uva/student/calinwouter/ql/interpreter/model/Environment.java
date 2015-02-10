package org.uva.student.calinwouter.ql.interpreter.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Environment {
    private HashMap<String, Object> envVars;

    private LinkedList<DisplayModelInterface> displayModels;

    public HashMap<String, Object> getEnvVars() { return envVars; }

    public LinkedList<DisplayModelInterface> getDisplayModels() { return displayModels; }

    public void clearDisplay() {
        displayModels.clear();
    }

    public Environment() {
        envVars = new HashMap<String, Object>();
        displayModels = new LinkedList<DisplayModelInterface>();
    }
}
