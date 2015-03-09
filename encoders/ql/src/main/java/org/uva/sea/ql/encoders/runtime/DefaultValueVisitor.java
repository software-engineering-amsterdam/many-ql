package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.type.DataTypeVisitor;
import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;

public class DefaultValueVisitor implements DataTypeVisitor<Object> {

	@Override
	public Object visit(BooleanType qlBoolean) {
		return false;
	}

	@Override
	public Object visit(IntegerType qlInteger) {
		return 0;
	}

	@Override
	public Object visit(StringType qlString) {
		return "";
	}

}
