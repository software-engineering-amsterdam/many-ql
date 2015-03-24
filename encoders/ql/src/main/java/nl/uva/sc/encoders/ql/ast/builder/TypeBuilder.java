package nl.uva.sc.encoders.ql.ast.builder;

import nl.uva.sc.encoders.ql.EncodersQLBaseVisitor;
import nl.uva.sc.encoders.ql.EncodersQLParser.BooleanTypeContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.IntegerTypeContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.StringTypeContext;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;

public class TypeBuilder extends EncodersQLBaseVisitor<DataType> {

	@Override
	public DataType visitBooleanType(BooleanTypeContext ctx) {
		return new BooleanType();
	}

	@Override
	public DataType visitIntegerType(IntegerTypeContext ctx) {
		return new IntegerType();
	}

	@Override
	public DataType visitStringType(StringTypeContext ctx) {
		return new StringType();
	}
}
