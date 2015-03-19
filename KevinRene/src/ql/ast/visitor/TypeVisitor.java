package ql.ast.visitor;

import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;

public interface TypeVisitor<T> {
	// Types contain nothing. An empty function will be the default visit action.
	default T visit(QLBoolean booleanNode) { return null; }
	default T visit(QLFloat floatNode) { return null; }   
	default T visit(QLForm formNode) { return null; } 
	default T visit(QLNumeric numericNode) { return null; }
	default T visit(QLInteger intNode) { return null; }
	default T visit(QLString stringNode) { return null; }
	default T visit(QLError errNode) { return null; }
	default T visit(QLMoney moneyNode) { return null; }
}
