package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.question.*;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.ExpressionSupporting;
import uva.ql.supporting.Tuple;

public class UIQuestion extends Observer implements UIWidget<Object> {
	
	protected Question question;
	protected SymbolMap symbolTable;
	protected Subject subject;
	
	private Component component;
	private Expression expression;
	
	public UIQuestion(Question _question, SymbolMap _symbolTable, Subject _subject, Expression _expression) {
        this.question = _question;		
        this.symbolTable = _symbolTable;
        this.subject = _subject;
        this.expression = _expression;
	}
	
	public UIContainer createElement() {
		UIContainer container = new UIContainer(new Tuple<Integer, Integer>(600,50));
		
		if (question.getType().getPrimitiveType() == PrimitiveType.BOOLEAN) {
			
			UICheckBox checkbox = new UICheckBox(this.question, this.symbolTable, this.subject, this.expression);
			return this.addWithOptions(checkbox.getWidget(), container);
		}
		else {
			
			UITextField textbox = new UITextField(this.question, this.symbolTable, this.subject, this.expression);
			return this.addWithOptions(textbox.getWidget(), container);
		}
	}
	private UIContainer addWithOptions(Component component, UIContainer container){
		this.component = component;
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(this.question.getQuestionText()), this.component));
		container.addComponents(components);
		return container;
	}
	
	public Component getComponent(){
		return this.component;
	}
	
	public Symbol getQuestionSymbol(){
		Symbol question = this.symbolTable.getSymbolForAttributes(this.getIdentifier(), null, Question.class.getName());
		return question;
	}
	
	@Override
	public void update(){
		this.subject.notifyObserver();
	}
	
	@Override
	public Object getWidgetValue() {
		return null;
	}
	
	@Override
	public String getIdentifier() {
		return this.question.getIdentifier().evaluate().getValue();
	}
	
	@Override
	public Expression getExpression() {
		
		if (this.expression == null){
			Symbol s = this.symbolTable.getSymbolForAttributes(this.getIdentifier(), this.question.getType().getTypeName(), Assign.class.getName());
			return (Expression)ExpressionSupporting.symbolAssignmentExists(s, this.getQuestionSymbol());
		}
		return this.expression;
	}
}