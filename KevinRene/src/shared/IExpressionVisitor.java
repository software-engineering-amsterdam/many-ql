package shared;

import ql.ast.expression.Identifier;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;

public interface IExpressionVisitor<T> {	
	default T visit(Identifier identNode) {	return null; }
	
	// Types contain nothing. An empty function will be the default visit action.
	default T visit(QLBoolean booleanNode) { return null; }
	default T visit(QLFloat floatNode) { return null; }   
	default T visit(QLForm formNode) { return null; } 
	default T visit(QLNumeric numericNode) { return null; }
	default T visit(QLInteger intNode) { return null; }
	default T visit(QLString stringNode) { return null; }
	default T visit(QLError errNode) { return null; }
	
	default T visit(BooleanLiteral booleanNode) { return null; }	
	default T visit(FloatLiteral floatNode) { return null; }
	default T visit(IntegerLiteral intNode) { return null; }
	default T visit(StringLiteral stringNode) {	return null; }
}
