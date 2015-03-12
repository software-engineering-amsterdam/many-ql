package org.uva.sea.ql.encoders.ast.type;

import java.util.HashMap;
import java.util.Map;

public class DataTypeTable {

	private final Map<String, DataType> dataTypes;

	public DataTypeTable() {
		dataTypes = new HashMap<>();
		add(new BooleanType());
		add(new StringType());
		add(new IntegerType());
	}

	private void add(DataType dataType) {
		dataTypes.put(dataType.getName(), dataType);
	}

	public DataType get(String name) {
		return dataTypes.get(name);
	}
}
