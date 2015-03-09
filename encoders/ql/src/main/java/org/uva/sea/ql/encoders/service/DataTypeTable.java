package org.uva.sea.ql.encoders.service;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;

public class DataTypeTable {

	private final Map<String, DataType> dataTypes;

	public DataTypeTable() {
		dataTypes = new HashMap<>();
		add(new BooleanType("boolean"));
		add(new StringType("string"));
		add(new IntegerType("integer"));
	}

	private void add(DataType dataType) {
		dataTypes.put(dataType.getName(), dataType);
	}

	public DataType get(String name) {
		return dataTypes.get(name);
	}
}
