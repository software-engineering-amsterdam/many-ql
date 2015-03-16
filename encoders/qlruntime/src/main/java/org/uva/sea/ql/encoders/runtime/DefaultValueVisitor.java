package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;
import org.uva.sea.ql.encoders.runtime.value.BooleanValue;
import org.uva.sea.ql.encoders.runtime.value.IntegerValue;
import org.uva.sea.ql.encoders.runtime.value.StringValue;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.visitor.DataTypeVisitor;

public class DefaultValueVisitor implements DataTypeVisitor<Value> {

	@Override
	public BooleanValue visit(BooleanType qlBoolean) {
		return new BooleanValue(false);
	}

	@Override
	public IntegerValue visit(IntegerType qlInteger) {
		return new IntegerValue(0);
	}

	@Override
	public StringValue visit(StringType qlString) {
		return new StringValue("");
	}

}
