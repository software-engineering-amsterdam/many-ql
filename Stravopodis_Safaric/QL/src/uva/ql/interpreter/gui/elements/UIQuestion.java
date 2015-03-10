package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.question.*;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.table.ExpressionTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;
import uva.ql.supporting.Tuple;

public class UIQuestion extends Observer implements UIWidget<Object> {
	
	protected Question question;
	protected ExpressionTable expressionTable;
	protected SymbolTable symbolTable;
	protected Subject subject;
	
	private Component component;
	private Expression expression;
	
	public UIQuestion(Question _question, ExpressionTable _expressionTable, SymbolTable _symbolTable, Subject _subject, Expression _expression) {
        this.question = _question;		
        this.expressionTable = _expressionTable;
        this.symbolTable = _symbolTable;
        this.subject = _subject;
        this.expression = _expression;
	}
	
	public UIContainer createElement() {
		UIContainer container = new UIContainer(new Tuple<Integer, Integer>(600,50));
		
		if (question.getType().getPrimitiveType() == PrimitiveType.BOOLEAN) {
			
			UICheckBox checkbox = new UICheckBox(this.question, this.expressionTable, this.symbolTable, this.subject, this.expression);
			this.checkIfExpressionWithinExpressionTable();
			return this.addWithOptions(checkbox.getWidget(), container);
		}
		else {
			
			UITextField textbox = new UITextField(this.question, this.expressionTable,this.symbolTable, this.subject, this.expression);
			this.checkIfExpressionWithinExpressionTable();
			return this.addWithOptions(textbox.getWidget(), container);
		}
	}
	private UIContainer addWithOptions(Component component, UIContainer container){
		this.component = component;
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(this.question.getQuestionText()), this.component));
		container.addComponents(components);
		return container;
	}
	
	private void checkIfExpressionWithinExpressionTable(){
		if (this.getExpression() != null){
			Expression expression = this.getExpression();
			String evaluatedClassName = PrimitiveType.classNameFromPrimitiveType(this.question.getType().getPrimitiveType());
			
			if (!this.expressionTable.keyExistsForType(this.question.getIdentifier(), evaluatedClassName)){	
				this.expressionTable.putValue(this.question.getIdentifier(), expression);
			}
		}
	}
	
	public Component getComponent(){
		return this.component;
	}
	
	@Override
	public void update(){
		this.subject.notifyObserver(this.expressionTable);
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
		return this.expression;
	}
}