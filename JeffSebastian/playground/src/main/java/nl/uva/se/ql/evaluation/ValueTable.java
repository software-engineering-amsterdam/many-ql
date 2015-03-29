package nl.uva.se.ql.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ql.evaluation.value.UndefinedValue;
import nl.uva.se.ql.evaluation.value.Value;

public class ValueTable {

	private Map<String, Value> values;

	public ValueTable() {
		values = new HashMap<String, Value>();
	}

	public Value getValue(String name) {
		if (values.containsKey(name)) {
			return values.get(name);
		}

		return new UndefinedValue();
	}

	public void addValue(String name, Value value) {
		values.put(name, value);
	}

	public boolean containsKey(String name) {
		return values.containsKey(name);
	}

}
