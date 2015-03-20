package nl.uva.sc.encoders.qlruntime.evaluator;

import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;
import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;
import nl.uva.sc.encoders.qlruntime.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.value.StringValue;
import nl.uva.sc.encoders.qlruntime.value.Value;

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
