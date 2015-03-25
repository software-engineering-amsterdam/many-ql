package nl.uva.softwcons.ql.eval;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.eval.value.Value;

public class FormAnswers {
    private final Map<Identifier, Value> answersTable;

    public FormAnswers() {
        answersTable = new HashMap<>();
    }

    public void setValue(final Identifier id, final Value value) {
        this.answersTable.put(id, value);
    }

    public Value getValue(final Identifier id) {
        return this.answersTable.getOrDefault(id, UNDEFINED);
    }
}
