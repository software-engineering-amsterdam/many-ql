package nl.uva.softwcons.eval;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.eval.value.UndefinedValue;
import nl.uva.softwcons.eval.value.Value;

public class FormAnswers {

    private Map<String, Value> answersTable;

    public FormAnswers() {
        answersTable = new HashMap<>();
    }

    public void setValue(String id, Value value) {
        this.answersTable.put(id, value);
    }

    public Value getValue(String id) {
        if (this.answersTable.containsKey(id)) {
            return this.answersTable.get(id);
        }
        return new UndefinedValue();
    }

}
