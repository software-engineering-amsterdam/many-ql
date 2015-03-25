package nl.uva.sc.encoders.ql.ast.type;

import java.util.HashMap;

public class TypeMap extends HashMap<String, DataType> {

	private static final long serialVersionUID = -8797388102308463127L;

	@Override
	public DataType get(Object key) {
		DataType dataType = super.get(key);
		if (dataType == null) {
			dataType = UndefinedType.UNDEFINED;
		}
		return dataType;
	}
}
