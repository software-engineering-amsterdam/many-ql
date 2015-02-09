package org.uva.student.calinwouter.ql.interpreter.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Environment {
    private HashMap<String, Object> envVars;

    private LinkedList<QuestionModel> questionModels;

    public HashMap<String, Object> getEnvVars() { return envVars; }

    public LinkedList<QuestionModel> getQuestionModels() { return questionModels; }

    public Environment() {
        envVars = new HashMap<String, Object>();
        questionModels = new LinkedList<QuestionModel>();
    }
}
