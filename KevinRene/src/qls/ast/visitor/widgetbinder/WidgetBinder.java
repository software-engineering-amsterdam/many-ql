package qls.ast.visitor.widgetbinder;

import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;
import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;

public class WidgetBinder extends StatementVisitor<Void> implements ExpressionVisitor<Void>, TypeVisitor<Void> {
	@Override
	public Void visit(QLBoolean booleanNode) {
		return null;
	}
	
	@Override
	public Void visit(QLFloat floatNode) {
		return null;
	}
	
	@Override
	public Void visit(QLInteger integerNode) {
		return null;
	}
	
	@Override
	public Void visit(QLString stringNode) {
		return null;
	}
	
	@Override
	public Void visit(BooleanLiteral booleanLiteral) {
		// SpinboxFactory.create(integerPrototype);
		// integerPrototype.createSpinbox();
		return null;
	}

	@Override
	public Void visit(FloatLiteral floatLiteral) {
		return null;
	}

	@Override
	public Void visit(IntegerLiteral integerLiteral) {
		return null;
	}

	@Override
	public Void visit(StringLiteral stringLiteral) {
		return null;
	}
}
