package gui;

import gui.widgets.IntegerField;
import gui.widgets.RadioButton;
import gui.widgets.TextField;
import gui.widgets.Widget;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.FloatLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLError;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLForm;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class WidgetFactory implements ExpressionVisitor<Widget>, StatementVisitor<Widget> {

	private final Identifier identifier;
	private final Controller controller;
	private final boolean enabled;
	
	public WidgetFactory(Identifier identifier, Controller controller, boolean enabled) {
		this.identifier = identifier;
		this.controller = controller;
		this.enabled = enabled;
	}
	public WidgetFactory(Identifier identifier, Controller controller) {
		this(identifier, controller, true);
	}
	
	@Override
	public Widget visit(QLString qlString) {
		return new TextField(identifier, controller, enabled);	
	}

	@Override
	public Widget visit(QLNumeric qlNumeric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(QLFloat qlFloat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(QLForm qlForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(QLInteger qlInteger) {
		return new IntegerField(identifier, controller, enabled);
	}

	@Override
	public Widget visit(QLBoolean qlBoolean) {
		return new RadioButton(identifier, controller, enabled);
	}

	@Override
	public Widget visit(QLError qlError) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(IntegerLiteral integerLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(FloatLiteral floatLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}
}
