package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.type.DataTypeVisitor;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.ast.type.QLInteger;
import org.uva.sea.ql.encoders.ast.type.QLString;

public class DefaultValueVisitor implements DataTypeVisitor<Object> {

	@Override
	public Object visit(QLBoolean qlBoolean) {
		return false;
	}

	@Override
	public Object visit(QLInteger qlInteger) {
		return 0;
	}

	@Override
	public Object visit(QLString qlString) {
		return "";
	}

}
