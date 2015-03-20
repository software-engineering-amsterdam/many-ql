package qls.ast.visitor.widgetbinder;

import java.util.ArrayList;
import java.util.List;

import ql.TypeEnvironment;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;
import qls.ast.Statement;
import qls.ast.statement.Block;
import qls.ast.statement.DefaultStyle;
import qls.ast.statement.DefaultWidget;
import qls.ast.statement.Question;
import qls.ast.statement.widget.Widget;
import qls.ast.statement.widget.type.Checkbox;
import qls.ast.statement.widget.type.Default;
import qls.ast.statement.widget.type.Spinbox;
import qls.ast.statement.widget.type.TextField;
import qls.ast.statement.widget.type.parameterised.Dropdown;
import qls.ast.statement.widget.type.parameterised.RadioButton;
import qls.ast.statement.widget.type.parameterised.Slider;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;
import qls.ast.visitor.WidgetEnvironment;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;
import qls.gui.builder.BooleanWidgetBuilder;
import qls.gui.builder.FloatWidgetBuilder;
import qls.gui.builder.IntegerWidgetBuilder;
import qls.gui.builder.MoneyWidgetBuilder;
import qls.gui.builder.StringWidgetBuilder;
import qls.gui.factory.CheckboxFactory;
import qls.gui.factory.DefaultFactory;
import qls.gui.factory.DropdownFactory;
import qls.gui.factory.RadioButtonFactory;
import qls.gui.factory.SliderFactory;
import qls.gui.factory.SpinboxFactory;
import qls.gui.factory.TextFieldFactory;
import qls.gui.widget.InputWidget;

public class WidgetBinder extends StatementVisitor<Object> implements ExpressionVisitor<QLType>, TypeVisitor<WidgetBuilder> {
	private DefaultWidgetEnvironment defaultWidgets;
	private WidgetEnvironment widgetEnvironment;
	private TypeEnvironment typeEnvironment;
	private List<Question> processedQuestions;
	
	private WidgetBinder(TypeEnvironment typeEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.typeEnvironment = typeEnvironment;
		
		defaultWidgets = new DefaultWidgetEnvironment();
		widgetEnvironment = new WidgetEnvironment();
		processedQuestions = new ArrayList<Question>();
	}
	
	public WidgetEnvironment getWidgetEnvironment() {
		return widgetEnvironment;
	}
	
	public static WidgetEnvironment bind(Statement statement, TypeEnvironment typeEnvironment) {
		WidgetBinder binder = new WidgetBinder(typeEnvironment);
		
		statement.accept(binder);
		
		return binder.getWidgetEnvironment();
	}
	
	private void bindDefaultQuestions() {
		processedQuestions.stream()
				.filter(question -> question.hasDefaultWidget())
				.forEach(question -> widgetEnvironment.store(question.getIdentifier(), 
										defaultWidgets.resolve(question.getIdentifier().accept(this))));
	}
	
	private void decreaseScope() {
		defaultWidgets = new DefaultWidgetEnvironment(defaultWidgets);
	}
	
	private void increaseScope() {
		defaultWidgets = defaultWidgets.getParent();
	}
	
	public Void visit(Block blockNode) {
		increaseScope();
		super.visit(blockNode);
		bindDefaultQuestions();
		decreaseScope();
		return null;
	}
	
	@Override
	public QLType visit(Identifier identifierNode) {
		return typeEnvironment.resolve(identifierNode);
	}
	
	@Override
	public WidgetBuilder visit(QLBoolean booleanNode) {
		return new BooleanWidgetBuilder();
	}
	
	@Override
	public WidgetBuilder visit(QLFloat floatNode) {
		return new FloatWidgetBuilder();
	}
	
	@Override
	public WidgetBuilder visit(QLInteger integerNode) {
		return new IntegerWidgetBuilder();
	}
	
	public WidgetBuilder visit(QLMoney moneyNode) {
		return new MoneyWidgetBuilder();
	}
	
	@Override
	public WidgetBuilder visit(QLString stringNode) {
		return new StringWidgetBuilder();
	}

	@Override
	public WidgetFactory visit(Checkbox checkboxNode) {
		return new CheckboxFactory();
	}

	@Override
	public WidgetFactory visit(Default dropdownNode) {
		return new DefaultFactory(defaultWidgets);
	}
	
	@Override
	public WidgetFactory visit(Dropdown dropdownNode) {
		return new DropdownFactory(dropdownNode.getFirstValue(), dropdownNode.getSecondValue());
	}

	@Override
	public WidgetFactory visit(RadioButton radioButtonNode) {
		return new RadioButtonFactory(radioButtonNode.getFirstValue(), radioButtonNode.getSecondValue());
	}

	@Override
	public WidgetFactory visit(TextField textFieldNode) {
		return new TextFieldFactory();
	}

	@Override
	public WidgetFactory visit(Spinbox spinnerNode) {
		return new SpinboxFactory();
	}

	@Override
	public WidgetFactory visit(Slider sliderNode) {
		return new SliderFactory(sliderNode.getFirstValue(), sliderNode.getSecondValue());
	}

	public Void visit(DefaultStyle defaultNode) {
		defaultWidgets.storeDefaultStyle(defaultNode.getType(), 
				defaultNode.getStyleProperties());
		
		super.visit(defaultNode);
		
		return null;
	}	

	public Void visit(DefaultWidget defaultNode) {
		WidgetFactory factory = (WidgetFactory) defaultNode.getWidget().accept(this);
		WidgetBuilder builder = defaultNode.getType().accept(this);
		
		InputWidget<?> widget = factory.create(builder, defaultNode.getWidget().getStyleRules());		
		defaultWidgets.store(defaultNode.getType(), widget);

		return null;
	}
	
	@Override
	public WidgetFactory visit(Widget widgetNode) {
		widgetNode.getStyleRules().accept(this);
		return (WidgetFactory) widgetNode.getWidgetType().accept(this);
	}
	
	@Override
	public Void visit(Question questionNode) {
		QLType questionType = questionNode.getIdentifier().accept(this);
		
		WidgetBuilder builder = questionType.accept(this);
		WidgetFactory factory = (WidgetFactory) questionNode.getWidget().accept(this);
		
		InputWidget<?> questionWidget = factory.create(builder, questionNode.getWidget().getStyleRules());
		widgetEnvironment.store(questionNode.getIdentifier(), questionWidget);
		
		processedQuestions.add(questionNode);
		return null;
	}
}
