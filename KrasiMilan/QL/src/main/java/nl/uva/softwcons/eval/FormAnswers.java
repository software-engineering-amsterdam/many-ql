package nl.uva.softwcons.eval;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.eval.value.UndefinedValue;
import nl.uva.softwcons.eval.value.Value;

public class FormAnswers {

    private Map<Identifier, Value> answersTable;

    public FormAnswers() {
        answersTable = new HashMap<>();
    }

    public void setValue(Identifier id, Value value) {
        this.answersTable.put(id, value);
    }

    public Value getValue(Identifier id) {
        return this.answersTable.getOrDefault(id, new UndefinedValue());
    }
}
